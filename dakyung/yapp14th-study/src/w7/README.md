# 7주차 

## 동적 프로그래밍(Dynamic Programming)

## 재귀(Recursive) vs 동적 프로그래밍
### 재귀적 문제
- 큰 문제의 해답에 작은 문제의 해답이 포함되어 있는 문제 
- ex) 1~10까지의 합 구하기 
    - 1부터 10까지 더하기 위해 1부터 9까지 합을 구한 뒤 그 결과값에 10을 더한다. 
### 동적 프로그래밍
- 재귀적 문제를 재귀로 구현할 경우 `필요 없는 중복`이 발생하는 경우가 있는데, 이 때 중복을 줄이기 위해 동적 프로그래밍을 한다.

### 피보나치 수열
#### 재귀적 해결
```java
static int fibonacci(int n) {
    if(n == 1|| n==2) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
}
public static void main(String[] args){
    int value = fibonacci(7);
}
```
- 중복 호출이 많다

#### 동적 프로그래밍
```java
static int[] a = new int[100]; // 계산 결과를 저장하기 위한 배열

static int fibonacci(int n) {
    if(a[0] != 0) return a[n]; // 탐색한 경우 다시 탐색하지 않는다.

    if(n == 1|| n==2) return a[n] = 1;
    else a[n] = fibonacci(n-1) + fibonacci(n-2);
    return a[n];
}
public static void main(String[] args){
    int value = fibonacci(7);
}
```
- 중복 호출을 막기 위해 중간에 계산 결과를 저장한다. 

### 행렬 경로 문제
|6|7|12|5|
|---|---|---|---|
|5|3|11|18|
|7|17|3|3|
|8|10|14|9|

- 정수들로 구성된 n*n 행렬
- 행렬의 좌상단에서 시작해 우하단까지 이동하는 경로를 찾는다.
- 이동방법(제약 조건) : **오른쪽**이나 **아래쪽**으로만 이동할 수 있다.
    - 왼쪽, 위쪽, 대각선 이동을 허용하지 않는다.
- 목표 : 행렬의 좌상단에서 시작해 우하단까지 이동하는 경로들 중 방문한 칸에 있는 수들을 더한 값이 **최소**가 되는 경로 찾기

#### 재귀적 해결
```
1. 이전 단계의 답은 제공되었다고 가정한 상황
2. 현 단계의 작업을 구현
3. 종료 조건을 구현 (이전 단계가 업는 단계의 작업 구현)
```
- 이차원 배열 `a[r][c]`의 값은 `(i,j)`칸을 지나갈 때의 비용
- 그러므로 `a[0][0]` 칸에서 `a[r][c]` 칸까지 가는 경로 합계의 최소값을 구하는 것.
- 우선 이를 `score(r,c)`라 한다면
1. 이전 단계의 답 제공
- `score(r, c-1), score(r-1, c)` 제공됨
2. 현 단계의 작업 구현 
```java
if(r > 0 && c > 0) // 해당 칸에 가기 위해 2가지 방법이 존재하기 때문에
                    // 둘 중 최소 값을 선택한다.
    beforeScore = score(r, c-1), score(r-1, c) 둘 중 최소 값
    currentScore = a[r][c]
    return beforeScore + currentScore
```

3. 종료 조건 구현
- 윗쪽 칸은 있고 왼쪽 칸이 없는 경우 
```java
if(r > 0 && c == 0) // 해당 칸에 가기 위해서는 윗칸에서 오는 방법이 유일
    이전 칸의 점수 = 점수(r, c - 1) 
    현재 칸의 점수 = a[r][c]
    return 이전 칸의 점수 + 현재 칸의 점수 
```
    
- 왼쪽 칸은 있고 윗쪽 칸이 없는 경우 
```java
if(r == 0 && c > 1) // 해당 칸에 가기 위해서는 왼쪽에서 오는 방법이 유일
    이전 칸의 점수 = 점수(r - 1, c) 
    현재 칸의 점수 = a[r][c]
    return 이전 칸의 점수 + 현재 칸의 점수
```
- 왼쪽, 윗쪽 둘 다 없는 경우 
```java
if(r == 0 && c == 0) // 출발 지점에 도착, 종료 조건
    현재 칸의 점수 = a[r][c] 
    return 현재 칸의 점수
```


- [소스 코드](./practice/MatrixPathRecursive.java)

#### 동적 프로그래밍 
- 기본적인 logic은 같지만 중복적인 재귀를 막기 위해 배열에 따로 데이터를 저장한다.
 - [소스 코드](./practice/MatrixPathDynamic.java)

 <br>