package w4.practice;

public class BinarySearchTreeTest {

    private static final int[] data = {3,10,2,5,4,14,11,16};
//    private static final int[] data = {2,3,4,5,8,10,11,14,16};

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree(8);

        for(int i : data){
            tree.insertNode(i);
        }

        searchResult(tree.searchNode(3));
        tree.deleteNode(3, tree);
        searchResult(tree.searchNode(3));
    }

    public static void searchResult(BinarySearchTree tree){
        if(tree != null)
            System.out.println("탐색 성공");
        else
            System.out.println("탐색 실패");
    }
}
