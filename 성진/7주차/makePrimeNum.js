function solution(nums) {
    let answer = 0;
    let allCase = [];
    
    for (let i = 0; i < nums.length - 2; i++) {
        for (let j = i + 1; j < nums.length - 1; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                allCase.push(nums[i] + nums[j] + nums[k]);
            }
        }
    }

    allCase.forEach(val => {
        let square = Math.floor(Math.sqrt(val));

        for (let i = 2; i < square + 1; i++) {
            if (val % i === 0) {
                return;
            }
        }

        answer++;
    });
    
    return answer;
}

console.log(solution([3, 2, 10, 2, 33]));