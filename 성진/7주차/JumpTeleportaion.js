function solution(n)
{
    let ans = 0;

    while(n !== 0) {
        if (n % 2 === 1) {
            n -= 1;
            ans++;
        } else n /= 2;
    }

    return ans;
}

console.log(solution(6));