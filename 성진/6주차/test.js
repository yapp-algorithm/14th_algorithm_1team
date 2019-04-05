(function (global) {
    "use strict";
    //피보나치 수열
    //재귀, 메모제이션, top-bottom, bottom-top 방식으로 구현
    let cacheFibo = [];

    let recursiveFibo = n => {
        if (!Number.isInteger(n) && n < 1) {
            console.log('invalid value!');
            return;
        }

        if (n === 1 || n === 2) {
            return 1;
        } else {
            return recursiveFibo(n - 1) + recursiveFibo(n - 2);
        }
    }

    let memoizationFibo = n => {
        if (!Number.isInteger(n) && n < 1) {
            console.log('invalid value!');
            return;
        }

        if (n === 1 || n === 2) {
            if (cacheFibo[n - 1] === undefined) {
                cacheFibo[n - 1] = 1;
                return cacheFibo[n - 1];
            } else {
                return cacheFibo[n - 1];
            }
        }

        if (cacheFibo[n - 1] === undefined) {
            return cacheFibo[n - 1] = memoizationFibo(n - 2) + memoizationFibo(n - 1);
        }

        return cacheFibo[n - 1];
    }

    let bottomTopFibo = n => {
        let cache = [];
        cache[0] = 1;
        cache[1] = 1;

        for (let i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n - 1];
    }


    console.log(recursiveFibo(1));
    console.log(recursiveFibo(2));
    console.log(recursiveFibo(3));
    console.log(recursiveFibo(4));
    console.log(recursiveFibo(5));
    console.log(recursiveFibo(6));

    console.log(bottomTopFibo(6));

    

}).call(this, typeof global !== 'undefined' ? global : typeof self !== 'undefined' ? self : typeof window !== 'undefined' ? window : {})