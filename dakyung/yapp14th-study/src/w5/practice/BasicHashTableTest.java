package w5.practice;

import sun.reflect.annotation.ExceptionProxy;

public class BasicHashTableTest {
    static class HashTable {
        static final int EMPTY = 0;
        static final int DELETED = -1;
        static final int SIZE = 37;
        int[] data;

        public HashTable() {
            data = new int[SIZE];
        }

        public void add(int value) throws Exception {
            int startIndex = value % SIZE;  // 저장할 위치 계산
            int count = 0;                  // 충돌 횟수
            do {
                int index = (startIndex + count) % SIZE;                // 저장할 위치 계산
//                int index = (startIndex + count * count) % SIZE;
                if (data[index] == EMPTY || data[index] == DELETED) {   // 비었으면 값을 저장
                    data[index] = value;
                    return;
                } else if (data[index] == value) return;                // 저장하려는 값이 있으면 리턴
                ++count;                                                // 조건문에 해당하지 않으면 충돌이 발생한 것
            } while (count < data.length);  // 충돌 횟수가 배열이 크기보다 크거나 같으면 실패
            throw new Exception("overflow");
        }

        public void remove(int value){
            int startIndex = value % SIZE;  // 삭제할 위치 계산
            int count = 0;                  // 충돌 횟수
            do {
                int index = (startIndex + count) % SIZE;
                if (data[index] == value) {         // 삭제하려는 값과 일치하면 삭제
                    data[index] = DELETED;          // 삭제된 위치 표시
                    return;
                } else if(data[index] == EMPTY){    // 해당 위치가 비어있으면 삭제 불가
                    return;
                }
                ++count;                            // 해당 위치가 다른 값이 있으면 충돌 발생
            }while(count < data.length);
        }

        public boolean contains(int value){
            int startIndex = value % SIZE;  // 찾을 위치 계산
            int count = 0;                  // 충돌 횟수
            do {
                int index = (startIndex + count) % SIZE;    // 찾을 위치 계산
                if(data[index] == EMPTY) return false;      // 비었으면 값이 해시 테이블에 없는 것
                else if(data[index] == value) return true;  // 값을 찾음
                ++count;                                    // 찾아간 위치가 다른 값이 있으면 충돌 발생.
            } while(count < data.length);                   // 충돌 횟수가 배열 크기를 넘어가면 실패
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();

        int[] data = {4,13,144,7,9,11,44,115,107,196};
        for(int i=0; i<data.length; i++)
            hashTable.add(data[i]);

        System.out.println("* After Add");
        for(int i=0; i<=maxValue; i++){
            if(hashTable.contains(i))
                System.out.println(i);
        }

        hashTable.remove(4);
        hashTable.remove(107);

        System.out.println("\n* After Delete");
        for(int i=0; i<=maxValue; i++){
            if(hashTable.contains(i))
                System.out.println(i);
        }
    }
}
