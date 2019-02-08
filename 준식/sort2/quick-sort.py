import random

def quick_sort(arr) :
    if len(arr) <= 1 :
        return arr
    else :
        # pivot을 array의 0번 원소로 지정
        pivot = arr[0]

        # array의 1번원소부터 비교해서 pivot보다 큰 원소는 gt에 저장
        # gt는 pivot 기준 오른쪽에 들어갈 array
        gt = [element for element in arr[1:] if element >= pivot]

        # array의 1번원소부터 비교해서 pivot보다 작은 원소는 ls에 저장
        # ls는 pivot 기준 왼쪽에 들어갈 array
        ls = [element for element in arr[1:] if not element >= pivot]

        # 위에서 분류된 ls와 gt를 각각 다시 재귀시키고
        # 가운데는 pivot을 할당
        return quick_sort(ls) + [pivot] + quick_sort(gt)


randoms = random.sample(range(1000), 100)
print(randoms)
randoms = quick_sort(randoms)
print(randoms)