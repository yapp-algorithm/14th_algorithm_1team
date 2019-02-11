# 2주차

## Merge Sort
### mergeSort(a[], start, end)
- if(start == end)면 정렬할 크기가 1이므로 그냥 리턴.
- if(start < end)면 정렬할 크기 2 이상.

#### 과정 
1. 배열을 반으로 쪼갠다.
2. 앞부분 배열을 정렬한다. (mergeSort)
3. 뒷부분 배열을 정렬한다.
4. 정렬된 앞, 뒤 배열을 병합한다. (merge) 

### merge(a[], start, middle, end)
- a1[]은 start~middle 정렬, a2[]는 middle+1~end 정렬.
- a1, a2는 각각 정렬된 상태 
- 두 배열의 앞부분을 비교해서 작은 것부터 먼저 임시 배열에 채워넣는다.
- 임시 배열의 값을 a 배열에 다시 채운다. 

### 수행시간
- 시간 복잡도 : merge 메소드 O(n), mergeSort는 배열을 나누고 배열 각각에 대해 mergeSort 재귀 호출을 함 logN. 따라서 mergeSort는 O(N logN) 
- 공간 복잡도 : merge 메소드에서 병합할 배열과 동일한 크기 임시 배열을 생성한다. 따라서 메모리 공간을 O(n) 사용함.

## Quick Sort

#### 과정
1. 임의의 값을 기준으로(보통 배열의 맨 끝값)
2. 기준값보다 작은 값은 배열의 앞부분으로 이동
3. 기준값보다 큰 값은 배열의 뒷부분으로 이동시킨다. 

- 기준값에 따라 성능이 달라진다.
    - 중간값을 기준값으로 고르면 배열이 1/2 크기로 나눠진다.

- 1구역 : 기준값보다 작거나 같은 값이 위치할 곳
- 2구역 : 기준값보다 큰 값들이 위치할 곳
- 3구역 : 아직 비교하지 않아서 위치가 정해지지 않은 값들

### 수행시간 
- partition 메소드 수행시간 O(n)

- 평균 : quickSort > logN 이므로 O(N logN)
- best case : partition 메소드가 배열을 1/2로 나눈다면 재귀 횟수가 logN이 되서 quickSort 메소드의 수행시간은 O(N logN)이 된다.
- worst case: partition 메소드가 배열을 0:n-1 크기로 나눈다면 재귀 횟수가 n이 된다. 따라서 수행시간은 O(n^2)

- 공간 복잡도 : quickSort, partition에서 사용하는 메모리 공간은 O(1)

## Heap Sort
- 