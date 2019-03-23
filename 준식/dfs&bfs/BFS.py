def BFS(adj ,s) :
    visited = []
    queue = [s]

    while queue :
        u = queue.pop(0)
        if u not in visited :
            visited.append(u)
            for v in adj[u] :
                if v not in visited :
                    queue.append(v)
    return visited

# def BFS_visit(adj, u, visited) :
#     if u not in visited :
#         visited.append(u)
#         for v in adj[u] :
#             if v not in visited :
#                 BFS_visit(adj, v, visited)
#
# def BFS_rec(adj, s) :
#     visited = []
#     BFS_visit(adj, s, visited)
#
#     return visited

paths = []

def bfs_paths(graph, start, end, path=[]):
    # 그전 방문했던 노드들 유지. 이번 차례 방문하는 꼭짓점도 visited에 추가
    path = path + [start]

    # 목적지에 도달했으면 paths 에 경로 기록 후 종료
    if start == end:
        paths.append(path)

    # bfs 와 같음
    queue = [start]

    while queue:
        vertex = queue.pop(0)

        for node in graph[vertex]:
            if node not in path:
                # 방문하지 않은 자손들에 대해 쭈우욱 재귀 호출
                bfs_paths(graph, node, end, path)


G1 = {1:[2,3], 2:[3,4,5], 3:[5,7,8], 4:[5], 5:[6], 6:[], 7:[8], 8:[]}
print(BFS(G1, 1))
#print(BFS_rec(G1, 1))

bfs_paths(G1, 1, 5)
print(paths)