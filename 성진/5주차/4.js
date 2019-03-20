"use strict";

class Node {
    constructor(vertex) {
        this.vertex = vertex;
        this.adj = [];
        this.next = null;
    }
    getVertex() {
        return this.vertex;
    }
    getAdj() {
        return this.adj;
    }
}

class Queue {
    constructor() {
        this.queue = [];
    }
    enqueue(data) {
        this.queue.push(data);
    }
    dequeue() {
        return this.queue.shift();
    }
    getValue() {
        return this.queue;
    }
}

class Graph {
    constructor(vertex) {
        let rootNode = new Node(vertex);
        this.root = rootNode;
    }

    getRoot() {
        return this.root;
    }

    setRoot(root) {
        this.root = root;
    }

    insert(vertex, adj) {
        //단일 방향 그래프로 생성 및 탐색 때 경로를 지우면서 탐색하면서, 더 이상 경로가 없을 때 만들어진 배열이 인풋 수 + 1 인 경우가 모든 경로를 도는 경우
        //즉, 저렇게 만들어진 모든 경로를 도는 경우에서 알파벳 순서가 앞서가는걸 찾아서 그걸 리턴

        let checkNode = this.root;
        let vertexNode, adjNode;
        while(1) {
            if (checkNode.vertex === vertex) vertexNode = checkNode;
            if (checkNode.vertex === adj) adjNode = checkNode;

            if (checkNode.next === null || (vertexNode !== undefined && adjNode !== undefined)) {
                if (adjNode === undefined) {
                    adjNode = new Node(adj);
                    checkNode.next = adjNode;
                }
                vertexNode.adj.push(adjNode);
                break;
            }

            checkNode = checkNode.next;
        }
        
    }

    findAllPath(graph, path, allPath, doneNum, root) {
        let checkNode = graph.getRoot();
        path.push(checkNode.vertex);

        if (checkNode.adj.length === 0 && path.length === doneNum) {
            allPath.push(path);
        } else if (checkNode.adj.length !== 0) {
            for (let i = 0; i < checkNode.adj.length; i++) {
                let nodes = [];
                let copyNodeRoot = root;
                let nowRootIndex = 0;
                while(1) {
                    let node = deepClone(copyNodeRoot);
                    nodes.push(node);
                    if (copyNodeRoot.next === null || isEmptyObject(copyNodeRoot.next)) break;
                    copyNodeRoot = copyNodeRoot.next;
                }
                let indexCheckNode = root;
                while(1) {
                    if (indexCheckNode.vertex === checkNode.vertex) break;
                    else {
                        nowRootIndex++;
                        indexCheckNode = indexCheckNode.next;
                    }
                }
                let nextGraph = new Graph();
                let nextVertex = nodes[nowRootIndex].adj.splice(i, 1);
                nextGraph.setRoot(nextVertex[0]);

                root = nodes[0];
                //깊은 복사 어떻게 하지...? 망할 클래스 안에 클래스..
                //깊은 복사 별 난리를 쳤는데 ㅈㅈ
                //깊은 복사만 되면 다음 경로가 있을 경우 다음 경로로 가면서 그 경로 지우는 형태로 해서 모든 경로에 대해 모든 경우를 보면서 path에 넣는 방식으로 갈수잇는 모든 경로 경우를 만든후
                //그 경로의 수가 인풋 수 + 1 일 경우 그게 최대로 다 도는 경우이므로 이런 경우에만 전체 경로에 넣고
                //전체 경로가 여러개일 경우 알파벳 순으로 출력하려 했음
                this.findAllPath(nextGraph, path, allPath, doneNum, root);
            }
        }

    }
}

function deepClone(obj) {
    var visitedNodes = [];
    var clonedCopy = [];
    function clone(item) {
        if (typeof item === "object" && !Array.isArray(item)) {
            if (visitedNodes.indexOf(item) === -1) {
                visitedNodes.push(item);
                var cloneObject = {};
                clonedCopy.push(cloneObject);
                for (var i in item) {
                    if (item.hasOwnProperty(i)) {
                        cloneObject[i] = clone(item[i]);
                    }
                }
                return cloneObject;
            } else {
                return clonedCopy[visitedNodes.indexOf(item)];
            }
        }
        else if (typeof item === "object" && Array.isArray(item)) {
            if (visitedNodes.indexOf(item) === -1) {
                var cloneArray = [];
                visitedNodes.push(item);
                clonedCopy.push(cloneArray);
                for (var j = 0; j < item.length; j++) {
                    cloneArray.push(clone(item[j]));
                }
                return cloneArray;
            } else {
                return clonedCopy[visitedNodes.indexOf(item)];
            }
        }

        return item; // not object, not array, therefore primitive
    }
    return clone(obj);
}

function isEmptyObject(obj) {
    for (var name in obj) {
        return false;
    }
    return true;
}

function solution(tickets) {
    let graph = new Graph('ICN');

    tickets.forEach(val => {
        graph.insert(val[0], val[1]);
    });

    graph.findAllPath(graph, [], [], tickets.length, graph.getRoot());
}

console.log(solution([['ICN', 'SFO'], ['ICN', 'ATL'], ['SFO', 'ATL'], ['ATL', 'ICN'], ['ATL', 'SFO']]));