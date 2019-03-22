def DFS_visit(adj, u, visited) :
    visited.append(u)
    for v in adj[u] :
        if v not in visited :
            DFS_visit(adj, v, visited)

def DFS_rec(adj, s) :
    visited = []
    DFS_visit(adj, s, visited)
    return visited


def DFS_stack(adj, s) :
    # 아래 while문에서 stack에서 일단 꺼내고 시작해야 하기 때문에
    # start 노드를 먼저 stack에 넣어 놓는다
    stack = [s]
    visited = []

    # stack이 빌 때 까지 아래 과정 반복
    while stack :
        # 현재 스택에서 가장 바깥에 있는 원소 get
        u = stack.pop()
        # 방문처리
        visited.append(u)
        # get 해온 노드와 인접한 노드들 중에서
        for v in adj[u] :
            # 방문하지 않은 노드들을
            if v not in visited :
                # 스택에 저장
                stack.append(v)

    return visited


paths = []

def dfs_paths(graph, start, end, visited=[]):
    # 그전 방문했던 노드들 유지. 이번 차례 방문하는 꼭짓점도 visited에 추가
    visited = visited + [start]

    # 도착했으면 paths 에 경로 기록하고 종료
    if start == end:
        paths.append(visited)

    # 현재 점의 자손 노드 중에 방문하지 않은 노드에 대해 재귀 호출
    for node in graph[start]:
        if node not in visited:
            dfs_paths(graph, node, end, visited)


G1 = {1: [2, 3], 2: [3, 4, 5], 3: [5, 7, 8], 4: [5], 5: [6], 6: [], 7: [8], 8: []}
result_rec = DFS_rec(G1, 1)
print(result_rec)

result_stack = DFS_stack(G1, 1)
print(result_stack)

dfs_paths(G1, 1, 5)
print(paths)