"use strict";

class Node {
    constructor(key, value, next = null, prev = null) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    getValue() {
        return this.value;
    }
    getNext() {
        return this.next;
    }
}
//데이터를 저장하기 위한 구조

class DefHashTable {
    constructor(count = 1) {
        this.data = Array.apply(null, new Array(count)).map(function() {return []});
        this.size = count;
    }
    //해시테이블 처음 생성할 시, 인자값으로 준 cnt 만큼 공간 할당

    hashFunction(key) {
        return key % this.size;
    }

    insert(key, value) {
        if (!Number.isInteger(key)) {
            console.log(`${key} is Invalid key. please enter number`);
        }

        this.chaining(key, value);
    }
    //삽입

    chaining(key, value) {
        let keyIndex = this.hashFunction(key);

        if(this.data[keyIndex].length === 0) {
            this.data[keyIndex].push(new Node(key, value));
        } else {
            let insertChain = this.data[keyIndex];
            let insertLength = insertChain.length;
            let prevNode = this.data[keyIndex][insertLength - 1];
            let insertData = new Node(key, value, null, prevNode);

            for(let i = 0; i < insertLength; i++) {
                if(insertChain[i].value === value) {
                    console.log(`${value} is already exists`);
                    return;
                }
            }
            
            this.data[keyIndex][insertLength] = insertData;
            prevNode.next = insertData;
        }
    }
    //chaining 으로 구현하였기 때문에, 처음 생성되는 키 또는 중복되는 키에 대한 chaining 함수

    find(key) {
        if (!Number.isInteger(key)) {
            console.log(`${key} is Invalid key. please enter number`);
        }
        let keyIndex = this.hashFunction(key);

        let findChain = this.data[keyIndex];
        let findLength = findChain.length;

        for(let i = 0; i < findLength; i++) {
            if (findChain[i].key === key) {
                console.log(findChain[i]);
                return findChain[i];
            }
        }

        console.log(`${key} is not exists`);
    }
    //키값으로 데이터를 찾을 때

    remove(key) {
        if (!Number.isInteger(key)) {
            console.log(`${key} is Invalid key. please enter number`);
        }
        let keyIndex = this.hashFunction(key);

        let removeChain = this.data[keyIndex];
        let removeLength = removeChain.length;

        for(let i = 0; i < removeLength; i++) {
            if (removeChain[i].key === key) {
                let prevNode = removeChain[i].prev;
                let nextNode = removeChain[i].next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                let result = removeChain.splice(i, 1);

                console.log(`${key} remove success`);

                return result;
            }
        }

        console.log(`${key} is not exists`);
    }
    //키값으로 데이터를 삭제할 때
}


let ht = new DefHashTable(23);

// chaining 해시테이블의 경우 소수이면서 2의 제곱수와 가깝지 않을 수록 좋다고 해서 그냥 23으로 함