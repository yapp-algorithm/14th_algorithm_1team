package w5.practice;

public class DoubleHashingHashTableTest {
    static class HashTable {
        static final int EMPTY = 0;
        static final int DELETED = -1;
        static final int SIZE = 37;
        static final int STEP_SIZE = 7;
        int[] data;

        public HashTable() {
            data = new int[SIZE];
        }

        public void add(int value) throws Exception {
            int startIndex = value % SIZE;
            int step = (value % STEP_SIZE) + 1;
            int count = 0;

            do{
                int index = (startIndex + count * step) % SIZE;         // 저장할 위치 계산, 충돌 발생 이후부터 step 적용
                if(data[index] == EMPTY || data[index] == DELETED) {    // 비었으면 값을 저장
                    data[index] = value;
                    return;
                } else if (data[index] == value)                        // 값이 이미 있으면 리턴
                    return;
                ++count;                                                // 충돌 발생
            }while(count < data.length);
            throw new Exception("overflow");
        }

        public void remove(int value) {
            int startIndex = value % SIZE;
            int step = (value % STEP_SIZE) + 1;
            int count = 0;

            do{
                int index = (startIndex + count * step) % SIZE; // index 계산하는 부분만 다르고 나머지 로직은 같다.
                if(data[index] == EMPTY) return;
                else if(data[index] == value) {
                    data[index] = DELETED;
                    return;
                }
                ++count;
            }while(count < data.length);
        }

        public boolean contains(int value){
            int startIndex = value % SIZE;
            int step = (value % STEP_SIZE) + 1;
            int count = 0;
            do {
                int index = (startIndex + count * step) % SIZE;
                if(data[index] == EMPTY) return false;
                else if(data[index] == value) return true;
                ++count;
            }while(count < data.length);
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();

        int[] data = {4, 13, 144, 7, 9, 11, 44, 115, 107, 196};

        for(int i = 0; i < data.length; i++){
            hashTable.add(data[i]);
        }

        hashTable.remove(11);
        hashTable.remove(44);

        for(int i = 1; i <= maxValue; i++)
            if(hashTable.contains(i))
                System.out.println(i);
    }
}
