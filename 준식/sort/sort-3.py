def solution(citations):
    answer = 0

    citations.sort()
    for i in range(1,1000) :
        cnt = 0
        for item in citations :
            if i <= item :
               cnt += 1

        if cnt < i :
            answer = i-1
            break

    return answer


arr = [3, 0, 6, 1, 5]
result = solution(arr)
print(result)