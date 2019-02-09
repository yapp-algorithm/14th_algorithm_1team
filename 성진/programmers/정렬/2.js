global.solution = numbers => {
    let piece = {};
    let makeIndex = [];
    let orderHighNum = {};

    numbers.forEach((val, idx) => {
        let num = String(val);
        let cutChar = [];
        for (let i = 0; i < num.length; i++) {
            cutChar.push(num.charAt(i));
        }
        piece[idx] = cutChar;
    });

    for (let i = 0; i < Object.size(piece); i++) {
        let nowStartNum = String(piece[i][0]);
        if (orderHighNum[nowStartNum] === undefined) {
            let arrayTemp = [i];
            orderHighNum[nowStartNum] = arrayTemp;
        } else {
            orderHighNum[nowStartNum].push(i);
        }
    }
    console.log(piece);

    reverseForIn(orderHighNum, function(key) {
        // let tempIndex = [];
        // for (let i = 0; this[key].length; i++) {
        //     if (i === 0) {
        //         tempIndex.push(this[key]);
        //     } else {
        //         tempIndex
        //     }
        // }
        // console.log(piece[this[key]]);
        // console.log(this[key]);
        console.log(key);
        this[key].forEach(val => {
            console.log(piece[val]);
        })
    });
    
}

Object.size = function(obj) {
    var size = 0, key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};

let reverseForIn = function (obj, func) {
    let arr = [];
    for (let key in obj) {
        arr.push(key);
    }

    for (let i = arr.length - 1; i >= 0 ; i--) {
        func.call(obj, arr[i]);
    }
}