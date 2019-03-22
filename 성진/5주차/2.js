"use strict";

class Node {
    constructor(vertex) {
        this.vertex = vertex;
        this.adj = [];
        this.next = null;
        this.visit = false;
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
    //양쪽 연결 그래프
    constructor(root) {
        this.root = root;
        let rootNode = new Node(0);
        this.root = rootNode;
    }

    getRoot() {
        return this.root;
    }

    insert(vertex, adj) {
        if (vertex === null || vertex === undefined || vertex === '' || adj === null || adj === undefined || adj === '') {
            console.log('invaild input!');
            //둘중 한개라도 없거나 둘다 같은 값일 경우
            return;
        }

        let checkNode = this.root;
        let input;
        let target;
        while(1) {

            if (checkNode.vertex === vertex) {
                input = checkNode;
            }

            if (checkNode.vertex === adj) {
                target = checkNode;
            }

            if (checkNode.next === null) {

                if (vertex === adj) {
                    if (input === undefined) {
                        let node = new Node(vertex);
                        checkNode.next = node;
                    }
                } else if (input !== undefined && target !== undefined) {
                    let duplicateCheck = false;
                    input.adj.forEach(val => {
                        if (val.vertex === adj) duplicateCheck = true;
                    });

                    target.adj.forEach(val => {
                        if (val.vertex === vertex) duplicateCheck = true;
                    });

                    if (duplicateCheck) {
                        break;
                    }

                    input.adj.push(target);
                    target.adj.push(input);
                } else if (input !== undefined && target === undefined) {
                    let node = new Node(adj);
                    checkNode.next = node;

                    node.adj.push(input);
                    input.adj.push(node);
                } else if (input === undefined && target !== undefined) {
                    let node = new Node(vertex);
                    checkNode.next = node;
                
                    node.adj.push(target);
                    target.adj.push(node);
                } else {
                    let node1 = new Node(vertex);
                    let node2 = new Node(adj);
                    checkNode.next = node1;
                    checkNode.next = node2;

                    node1.adj.push(node2);
                    node2.adj.push(node1);
                }

                break;
            }

            checkNode = checkNode.next;
        }
        
    }

    BFS_network_init() {
        let checkNode = this.root;

        while(1) {
            checkNode.visit = false;
            if (checkNode.next === null) break;
            checkNode = checkNode.next;
        }
    }

    BFS_network_counting(node) {
        let queue = new Queue();

        queue.enqueue(node);
        node.visit = true;
        
        while(1) {
            let nowNode = queue.dequeue();
            
            nowNode.adj.forEach(val => {
                if (!val.visit) {
                    val.visit = true;
                    queue.enqueue(val);

                    // console.log(`${nowNode.vertex} -> ${val.vertex}`);
                }
            });

            if (queue.getValue().length === 0) break;
        }
    }

    BFS_network() {
        this.BFS_network_init();
        let target = this.root;
        let answer = 0;

        while(target !== null) {
            if (!target.visit) {
                this.BFS_network_counting(target);
                answer++;
            }
            target = target.next;
        }

        return answer;
    }
}

function solution(n, computers) {
    let graph = new Graph();

    for (let i = 0; i < n; i++) {
        computers[i].forEach((val, idx) => {
            if (val === 1) {
                graph.insert(i, idx);
            }
        });
    }

    return graph.BFS_network();
}

console.log(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]));
//그래프로 만들고 그래프의 요소들을 돌면서 연결되어 있으면 visit은 true 가 되므로 전체 그래프를 돌면서 연결된 부위가 끝날 때 마다 카운트를 올리는 방식