def DFS(computers, visited) :
    stack = []
    for idx, v in enumerate(visited) :
        if v == 0 :
            stack.append(idx)
            break


    # stack이 빌 때 까지 아래 과정 반복
    while stack :
        # 현재 스택에서 가장 바깥에 있는 원소 get
        u = stack.pop()
        # 방문처리
        visited[u] = 1
        # get 해온 노드와 인접한 노드들 중에서
        for idx, v in enumerate(computers[u]) :
            # 방문하지 않은 노드들을
            if visited[idx] == 0 and v == 1:
                # 스택에 저장
                stack.append(idx)



def solution(n, computers):
    answer = 0

    if n == 0 or len(computers) == 0 :
        return 0

    visited = [0] * n

    while True :
        if 0 not in visited :
            break
        else :
            DFS(computers, visited)
            answer += 1

    return answer


n = 7
#computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
#computers = [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
computers = [[1,1,0,0,0,0,0], [1,1,1,0,0,0,1], [0,1,1,0,0,0,0], [0,0,0,1,1,1,0], [0,0,0,1,1,0,0], [0,0,0,1,0,1,0], [0,1,0,0,0,0,1]]
print(solution(n, computers))