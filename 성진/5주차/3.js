"use strict";

class Node {
    constructor(vertex) {
        this.vertex = vertex;
        this.adj = [];
        this.next = null;
        this.visit = false;
        this.routeCnt = 0;
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
    constructor(begin) {
        let rootNode = new Node(begin);
        this.root = rootNode;
        this.vertexs = [];
        this.vertexs.push(begin);
    }

    getRoot() {
        return this.root;
    }

    insert(vertex) {
        //중복되는 단어가 없으므로 무조건 new Node 를 통해 생성하고 현재 연결 된 모든 그래프와 한글자만 다른지 확인해서 서로 연결해줌
        //더 좋은 방법이 있을 꺼같긴 한데..
        if (this.vertexs.includes(vertex)) return;

        let checkNode = this.root;
        let insertWord = new Node(vertex);
        this.vertexs.push(vertex);
        while(1) {
            let diffCnt = 0;
            for (let i = 0; i < vertex.length; i++) {
                if (checkNode.vertex.charAt(i) !== vertex.charAt(i)) {
                    diffCnt++;
                }

                if (diffCnt > 1) break;
            }

            if (diffCnt === 1) {
                checkNode.adj.push(insertWord);
                insertWord.adj.push(checkNode);
            }

            if (checkNode.next === null) {
                checkNode.next = insertWord;
                break;
            }

            checkNode = checkNode.next;
        }
        
    }

    findSortestPath(start, end) {
        let queue = new Queue();
        let checkNode = this.root;
        let startTarget, endTarget;
        while(1) {
            checkNode.visit = false;
            checkNode.routeCnt = 0;
            if (checkNode.vertex === start) startTarget = checkNode;
            if (checkNode.vertex === end) endTarget = checkNode;
            if (checkNode.next === null) break;
            checkNode = checkNode.next;
        }

        if (endTarget === undefined) return 0;

        queue.enqueue(startTarget);
        startTarget.visit = true;
        while(1) {
            let nowNode = queue.dequeue();
            
            nowNode.adj.forEach(val => {
                if (!val.visit) {
                    val.visit = true;
                    val.routeCnt = nowNode.routeCnt + 1;
                    queue.enqueue(val);
                }
            });

            if (queue.getValue().length === 0) break;
        }

        return endTarget.routeCnt;
    }
}

function solution(begin, target, words) {
    let graph = new Graph(begin);

    words.forEach(val => {
        graph.insert(val);
    });
    //시작 단어에서부터 삽입 된 워드들에 대한 1글자만 다를경우 연결하는 그래프 생성
    //BFS 로 시작단어에서부터 원하는 타겟 단어까지의 경로를 이전 경로에서 연결된 경우 이전 경로의 라우팅 카운트에서 1 증가하는 형태로 점점 카운팅을 늘리는 방식으로 구현

    return(graph.findSortestPath(begin, target));
}

console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log']));