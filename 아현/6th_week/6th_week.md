# 동적 계획법 (Dynamic Programming)
전체 문제를 풀기 위해 작은 문제의 답을 기반으로 전체 문제를 풀어가는 방법

→ 하나의 문제는 단 한 번만 풀도록!
 
## 조건
1. 겹치는 부분 문제 (Overlapping Subproblem)
    - 큰 문제와 작은 문제를 같은 방법으로 쪼갤 수 있다.
    - 같은 재귀함수 호출 반복
2. 최적 부분구조 (Optimal Substructure)
    - 전체 문제의 정답을 작은 문제의 정답에서 구할 수 있다.
    - 문제의 크기와 상관없이 어떤 한 문제의 정답은 일정하다.
    
## 메모이제이션 (Memoization)
중간 계산 결과를 버리지 않고 배열(cache)에 저장한 뒤, 다음 계산에서 불러오는 기법

## 풀이 방법
- Top Down
    - 큰 문제를 작은 문제로 나누고, 해결된 작은 문제들을 이용해 큰 문제를 해결한다.
    - 재귀함수 + 메모이제이션
- Bottom Up
    - 문제를 크기가 작은 문제부터 차례대로 푼다.
    - 문제의 크기를 조금씩 크게 만들면서 문제를 점진적으로 풀어나간다.
    - 반복문 + 배열


## 문제
- 피보나치
- 이항 계수



https://dev-jangwon.github.io/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/2017/02/16/algorithm-dp/
https://dpdpwl.tistory.com/57
https://new93helloworld.tistory.com/220
https://janghw.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Dynamic-Programming-%EB%8F%99%EC%A0%81-%EA%B3%84%ED%9A%8D%EB%B2%95
https://blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221233570962