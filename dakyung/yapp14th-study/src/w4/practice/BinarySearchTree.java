package w4.practice;

public class BinarySearchTree {
    int key;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public void insertNode(int key){
        if(key < this.key){
            if(this.left == null) this.left = new BinarySearchTree(key);
            else this.left.insertNode(key);
        }else if(key > this.key) {
            if(this.right == null) this.right = new BinarySearchTree(key);
            else this.right.insertNode(key);
        }
    }

    public BinarySearchTree searchNode(int key){
        BinarySearchTree node = this;
        while(node != null){
            if(key == node.key) return node;
            else if(key < node.key) node = node.left;
            else if(key > node.key) node = node.right;
        }
        return node;
    }

    public void deleteNode(int key, BinarySearchTree parent){
        if(key < this.key){
            if(this.left != null) left.deleteNode(key, this);
        }else if(key > this.key){
            if(this.right != null) right.deleteNode(key, this);
        }else {
            if(this.left != null && this.right != null){ // 자식 노드가 2개인 경우
                // 삭제하려는 노드의 오른쪽 서브 트리 중 가장 작은 값인 왼쪽 노드를 찾는다.
                int temp = this.right.getLeftMostValue();
                this.key = temp;
                right.deleteNode(temp, this);
            }else { // 자식 노드가 없거나 1개인 경우
                BinarySearchTree child = (this.left != null) ? left : right;
                if(parent.left == this) parent.left = child;
                else parent.right = child;
            }
        }
    }

    private int getLeftMostValue(){
        if(this.left != null) return this.left.getLeftMostValue();
        return this.key;
    }
}
