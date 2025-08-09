package CodingBlocksQuestions;
import java.util.*;

public class CreateTreeUsingPreorderAndInorder {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CreateTreeUsingPreorderAndInorder m = new CreateTreeUsingPreorderAndInorder();
        int n = scn.nextInt();
        int[] pre = takeInput(n);
        int[] in = takeInput(n);
        BinaryTree bt = m.new BinaryTree(pre, in);
        bt.display();
    }

    public static int[] takeInput(int n) {

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

            // write your code here
            if(plo>phi || ilo>ihi){
                return null;
            }

            Node nn = new Node();
            nn.data = pre[plo];

            int irootidx = -1;
            for(int i=ilo; i<=ihi; i++){
                if(in[i]==pre[plo]){
                    irootidx = i;
                    break;
                }
            }

            int leftSubtreeSize = irootidx - ilo;

            nn.left = construct(pre, plo+1, plo+leftSubtreeSize, in, ilo, irootidx-1);
            nn.right = construct(pre, plo+leftSubtreeSize+1, phi, in, irootidx+1, ihi);
            return nn;
        }

        public void display() {
            if(this.root==null){
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.root);

            while(!queue.isEmpty()){
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            System.out.println("");
        }

    }

}
