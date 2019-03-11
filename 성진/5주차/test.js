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

    BFS(vertex) {
        let queue = new Queue();
        let checkNode = this.root;
        let target;
        while(1) {
            checkNode.visit = false;
            if (checkNode.vertex === vertex) target = checkNode;
            if (checkNode.next === null) break;
            checkNode = checkNode.next;
        }

        if (target === undefined) {
            console.log('Input data does not exist');
            return;
        }

        queue.enqueue(target);
        target.visit = true;
        
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

    DFS(vertex) {
        let checkNode = this.root;
        let target;

        while(1) {
            checkNode.visit = false;
            if (checkNode.vertex === vertex) target = checkNode;
            if (checkNode.next === null) break;
            checkNode = checkNode.next;
        }

        if (target === undefined) {
            console.log('Input data does not exist');
            return;
        }

        target.visit = true;

        this.DFS_search(target);        
    }

    DFS_search(target) {
        target.adj.forEach(val => {
            if(!val.visit) {
                val.visit = true;

                console.log(`${target.vertex} -> ${val.vertex}`);
                this.DFS_search(val);
            }
        });
    }
}

let graph = new Graph();

graph.insert(0, 1);
graph.insert(0, 2);
graph.insert(0, 4);
graph.insert(1, 2);
graph.insert(2, 3);
graph.insert(2, 4);
graph.insert(3, 4);

graph.BFS(3);
graph.DFS(3);