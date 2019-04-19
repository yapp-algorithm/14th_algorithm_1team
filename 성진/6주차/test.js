// 전체적인 알고리즘
// 문자열의 맨 앞 인덱스부터 제일 끝 인덱스를 시작으로 팰린드롬 확인
// 현재 보고 있는 인덱스들이 팰린드롬이 아닐 경우 끝 인덱스를 1개씩 줄이면서 확인
// 현재 인덱스들이 팰린드롬일 경우 그 길이를 확인하고 지금까지의 팰린드롬의 최대 길이와 비교하여 큰 값으로 대체
// 시작과 끝이 만날 경우, 시작 인덱스를 1개 증가시켜 앞의 작업을 반복하여 위의 작업을 반복하여 맨 마지막 인덱스까지 확인

function solution(s){
    let answer = 0;

    if (s.length === 1) return 1;
    //1글자일 경우 무조건 팰린드롬이므로 1을 리턴

    for (let i = 0; i < s.length; i++) {
        //시작 문자를 뒤를 볼 필요가 없는 이유는, 팰린드롬의 정의가 가운데를 기준으로 같은 값을 확인하는 것이므로 사실상 한번 보는게 양옆을 보는것과 같음

        if (s.length - i < answer) return answer;
        //위의 이유로 시작 인덱스는 점점 문자열 끝으로 가고, 시작 인덱스와 끝 인덱스 사이의 거리가 현재까지 발견한 팰린드롬의 최대 길이보다 작은 경우는
        //팰린드롬이 존재하더라도 무조건 작으므로 지금까지 구한 최대 값을 리턴
        
        for (let j = s.length; j > i; j--) {
            if (checkPalindrome(s.substring(i, j))) {
                //현재 인덱스들이 팰린드롬일 경우 이보다 작은 인덱스에 존재하더라도 최대값이 되지 않으므로
                //지금까지 구한 최대값과 비교하여 브레이크
                if (answer < j - i) answer = j - i;
                break;
            }
        }
    }
    
    return answer;
}

let checkPalindrome = s => {
    //팰린드롬을 확인하는 함수
    for (let i = 0; i < Math.floor(s.length / 2); i++) {
        if (s[i] !== s[s.length - i - 1]) {
            return false;
            //확인 도중 아닌 경우 바로 false 를 리턴
        }
    }

    return true;
}

console.log(solution('a'));

/*
function solution(n, m){
    //단순히 인풋으로 들어오는 숫자를 문자열로 변환 및 대응되는 인덱스끼리 비교
    //현재 비교하고 있는 인덱스가 서로 다를 경우 정답에서 1을 빼는 이유는 모든 인풋에 대해 더하는 카운팅을 했으므로
    //맞지 않은 경우에는 빼줌으로써 현재 보고 있는 인덱스가 맞지 않을 경우 -1 +1 을 하여 결과적으로 그대로로 만들기 위해
    
    let answer = 0

    for (let i = n; i < m + 1; i++) {
        for (let j = 0; j < Math.floor(i.toString().length / 2); j++) {
            if (i.toString()[j] !== i.toString()[i.toString().length - j - 1]) {
                answer--;
                break;
            }
        }
        answer++;
    }
    
    return answer;
}
*/