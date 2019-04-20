//ㅈㅈ

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
    //양쪽 연결 그래프
    constructor(root) {
        this.root = root;
        let rootNode = new Node(1);
        this.root = rootNode;
        this.vertexs = [1];
    }

    getRoot() {
        return this.root;
    }

    insert(insertValue) {
        let vertex = insertValue[0], adj = insertValue[1], weight = insertValue[2];
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

                    input.adj.push([target, weight]);
                    target.adj.push([input, weight]);
                } else if (input !== undefined && target === undefined) {
                    let node = new Node(adj);
                    checkNode.next = node;

                    node.adj.push([input, weight]);
                    input.adj.push([node, weight]);

                    this.vertexs.push(adj);
                } else if (input === undefined && target !== undefined) {
                    let node = new Node(vertex);
                    checkNode.next = node;
                
                    node.adj.push([target, weight]);
                    target.adj.push([node, weight]);

                    this.vertexs.push(vertex);
                } else {
                    console.log('adj target is not exits');
                    //입력 된 노드 2개 모두 없을 경우
                }

                break;
            }

            checkNode = checkNode.next;
        }
        
    }

    findRoute(node, target, weight, routes = [1]) {
        let routeWeight;

        node.adj.forEach(val => {
            if (val[0].vertex === target) {
                weight += val[1];
                if (routeWeight !== undefined && weight < route) {
                    routeWeight = tmpRoute;
                } else if(routeWeight === undefined) {
                    routeWeight = weight;
                }
            } else if (!routes.includes(val[0].vertex)) {
                routes.push(val[0].vertex);
                weight += val[1];

                let tmpRouteWeight = this.findRoute(val[0], target, weight, routes);

                if (routeWeight !== undefined && tmpRouteWeight < routeWeight) routeWeight = tmpRouteWeight;
            }
        });

        return routeWeight;
    }
    // 그래프 구현 및 연결 된 구간끼리의 비용까지 넣는 그래프 그리는건 완성
    // 최소한의 값으로 1지점에서 타겟 지점으로 이동하는 함수를 만들기만 하면 되는데 그걸 못하고 ㅈㅈ침
}

function solution(N, road, K) {
    let answer = 0;
    let graph = new Graph();

    road.forEach(val => {
        graph.insert(val);
    });

    graph.findRoute(graph.getRoot(), 3, 0);

    return answer;
}

solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3);