def DFS(numbers, target, idx, cur_num) :
    if idx == len(numbers) :
        if cur_num == target :
            return 1
        else :
            return 0
    else :
        return DFS(numbers, target, idx+1, cur_num + numbers[idx]) + \
                DFS(numbers, target, idx+1, cur_num - numbers[idx])
def solution(numbers, target):
    answer = 0

    answer = DFS(numbers, target, 0, 0)

    return answer


numbers = [1, 1, 1, 1, 1]
print(solution(numbers, 3))