package MonuBhaiyaPractice;

public class BSTree {
    class Node {
        int val;
        Node left;
        Node right;
    }

    @SuppressWarnings("unused")
    private Node root;
    
    public BSTree(int[] arr) {
        root = createTree(arr, 0, arr.length-1);
    }
    
    private Node createTree(int[] arr, int si, int ei) {
        if(si>ei){
            return null;
        }
        int mid = (si + ei)/2;
        Node nn = new Node();
        nn.val = arr[mid];
        nn.left = createTree(arr, si, mid-1);
        nn.right = createTree(arr, mid + 1, ei);
        return nn;
    }

}
