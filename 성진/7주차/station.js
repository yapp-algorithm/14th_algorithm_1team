function solution(n, stations, w) {
    stations = stations.sort();

    let answer = 0;
    let emptyLength = 0;
    let startIdx = stations - w < 0 ? 0 : stations - w;
    let apt = {};

    for(let i = 1; i < n + 1; i++) {
        apt[i] = false;
    }
    
    stations.forEach(val => {
        if (val - w < 1) {
            for (let i = 1; i < val + w + 1; i++) {
                if (i > n) break;
                apt[i] = true;
            }
        } else {
            for (let i = val - w; i < val + w + 1; i++) {
                if (i > n) break;
                apt[i] = true;
            }
        }
    });

    for(let i = 1; i < n + 1; i++) {
        if(apt[i] && emptyLength !== 0) {
            answer += (Math.floor(emptyLength / (w * 2 + 1)));
            if (emptyLength % (w * 2 + 1) !== 0) answer++;
            emptyLength = 0;
        } else if (!apt[i]) emptyLength++;

        if (i === n && emptyLength !== 0){
            answer += (Math.floor(emptyLength / (w * 2 + 1)));
            if (emptyLength % (w * 2 + 1) !== 0) answer++;
        }
    }
    return answer;
}

console.log(solution(16,[9],2));