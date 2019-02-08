import random

def merge(left, right):
    # 정렬된 array 를 저장할 공간
    result = []
    # left의 길이가 0 보다 크거나 right의 길이가 0 보다 클 때 동안
    while len(left) > 0 or len(right) > 0:
        # 만약 left의 길이도 0보다 크고 right의 길이도 0보다 크다면
        if len(left) > 0 and len(right) > 0:
            # left와 right의 원소를 차례차례 비교하면서
            # 작은값을 result에 넣고 그 작은값에 해당하는 array의 현재 index를 1 증가시킨다
            if left[0] <= right[0]:
                result.append(left[0])
                left = left[1:]
            else:
                result.append(right[0])
                right = right[1:]
        # right에는 더이상 원소가 없고 left에만 남아있을 경우
        # left의 남은 원소를 차례대로 result에 넣는다
        elif len(left) > 0:
            result.append(left[0])
            left = left[1:]
        # left에는 더이상 원소가 없고 right에만 남아있을 경우
        # right의 남은 원소를 차례대로 result에 넣는다
        elif len(right) > 0:
            result.append(right[0])
            right = right[1:]
    return result

def merge_sort(list):
    if len(list) <= 1:
        return list

    # 가운데 index값
    mid = len(list) // 2

    # mid값을 기준으로 왼쪽
    leftList = list[:mid]

    # mid값을 기준으로 오른쪽(mid 포함)
    rightList = list[mid:]

    # 현재 array를 기준으로 왼쪽 재귀(분할)
    leftList = merge_sort(leftList)

    # 현재 array를 기준으로 오른쪽 재귀(분할)
    rightList = merge_sort(rightList)

    # 위의 재귀가 끝나면 현재 함수에서 merge 결과 반환
    return merge(leftList, rightList)


randoms = random.sample(range(1000), 100)
print(randoms)
randoms = merge_sort(randoms)
print(randoms)