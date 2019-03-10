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
        if (vertex === null || vertex === undefined || vertex === '' || adj === null || adj === undefined || adj === '' || vertex === adj) {
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
                if (input !== undefined && target !== undefined) {
                    let duplicateCheck = false;
                    input.adj.forEach(val => {
                        if (val.vertex === adj) duplicateCheck = true;
                    });

                    target.adj.forEach(val => {
                        if (val.vertex === vertex) duplicateCheck = true;
                    });

                    if (duplicateCheck) {
                        console.log('already connected');
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
                    console.log('adj target is not exits');
                    //입력 된 노드 2개 모두 없을 경우
                }

                break;
            }

            checkNode = checkNode.next;
        }
        
    }

    BFS() {
        let queue = new Queue();
        let checkNode = this.root;
        while(1) {
            checkNode.visit = false;
            if (checkNode.next === null) break;
            checkNode = checkNode.next;
        }

        queue.enqueue(this.root);
        this.root.visit = true;
        
        while(1) {
            let nowNode = queue.dequeue();
            
            nowNode.adj.forEach(val => {
                if (!val.visit) {
                    val.visit = true;
                    queue.enqueue(val);

                    console.log(`${nowNode.vertex} -> ${val.vertex}`);
                }
            });

            if (queue.getValue().length === 0) break;
        }
    }
}

let BFSgraph = new Graph();

BFSgraph.insert(0, 1);
BFSgraph.insert(0, 2);
BFSgraph.insert(0, 4);
BFSgraph.insert(1, 0);
BFSgraph.insert(1, 2);
BFSgraph.insert(2, 0);
BFSgraph.insert(2, 1);
BFSgraph.insert(2, 3);
BFSgraph.insert(2, 4);
BFSgraph.insert(3, 2);
BFSgraph.insert(3, 4);
BFSgraph.insert(4, 0);
BFSgraph.insert(4, 2);
BFSgraph.insert(4, 3);

BFSgraph.BFS();