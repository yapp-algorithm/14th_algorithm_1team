def comp(a,b) :
    return a <= b if len(a) == len(b) else a+b <= b+a

def quick_sort(arr) :
    if len(arr) <= 1 :
        return arr
    else :
        pivot = arr[0]
        gt = [element for element in arr[1:] if comp(element, pivot)]
        ls = [element for element in arr[1:] if not comp(element, pivot)]
        return quick_sort(ls) + [pivot] + quick_sort(gt)


def solution(numbers) :
    if set(numbers) == {0} :
        return "0"

    numbers_s = [str(number) for number in numbers]
    numbers_s = quick_sort(numbers_s)
    print(numbers_s)
    return "".join(numbers_s)



print(solution([20, 200, 20]))
print(solution([0,0,0]))
print(solution([0,0,0,1000]))
print(solution([0,0,1000,0]))
print(solution([1000,0,0,0]))
print(solution([3, 30, 34, 5, 9]))
print(solution([6, 10, 2]))
print(solution([0, 0, 80]))
print(solution([80, 0, 0, 800]))
print(solution([12, 121]))
print(solution([21, 212]))
print(solution([35, 353]))