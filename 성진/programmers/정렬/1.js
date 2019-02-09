function solution(array, commands) {
    let answer = [];
    commands.forEach(val => {
        let startIndex = val[0] - 1;
        let splitNum = val[1] - val[0] + 1;
        let answerIndex = val[2] - 1;
        let splitArray = array.slice(0).splice(startIndex, splitNum);

        answer.push(quickSort(splitArray)[answerIndex]);

    });

    return answer;
}

let quickSort = array => {
    let merge = [];

    if (array.length < 2) return array;

    let pivot = array[array.length - 1];
    let start = 0;
    let end = array.length - 2;

    while(start <= end) {
        if (array[start] > pivot && array[end] <= pivot) {
            let temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        } else if (array[start] <= pivot) {
            start++;
        } else if (array[end] > pivot) {
            end--;
        }
    }

    quickSort(array.slice(0).splice(0, start)).forEach(val => {
        merge.push(val);
    });
    merge.push(pivot);
    quickSort(array.slice(0).splice(start, array.length - start - 1)).forEach(val => {
        merge.push(val);
    });

    return merge;
}