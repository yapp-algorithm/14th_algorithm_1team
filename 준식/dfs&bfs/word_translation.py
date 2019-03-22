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

def make_graph(words) :
    if len(words) == 0 :
        return None

    graph = {}
    leng = len(words[0])
    for word1 in words :
        value_tmp = []
        for word2 in words :
            if word1 == word2 :
                continue

            cnt = 0
            for idx in range(leng) :
                if word1[idx] != word2[idx] :
                    cnt += 1

            if cnt == 1 :
                value_tmp.append(word2)

        graph[word1] = value_tmp

    return graph

def solution(begin, target, words):
    answer = 0

    if target not in words :
        return 0

    graph = make_graph([begin] + words)

    #print(graph)

    bfs_paths(graph, begin, target)

    m = 51
    for path in paths :
        if m > len(path) :
            m = len(path)

    answer = m - 1

    return answer


begin = 'hit'
target = 'cog'
words = ['hot', 'dot', 'dog', 'lot', 'log', 'cog']
result = solution(begin, target, words)
print(result)
#print(paths)


