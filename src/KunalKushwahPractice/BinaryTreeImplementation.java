package KunalKushwahPractice;
import java.util.*;

public class BinaryTreeImplementation {
    public static Scanner sc = new Scanner(System.in);
    class BinaryTree{
        public BinaryTree(){

        }

        private static class Node{
            int value;
            Node left;
            Node right;

            public Node(int value){
                this.value = value;
            }
        }

        private Node root;

        public void populate(){
            System.out.println("Enter root node");
            int val = sc.nextInt();
            root = new Node(val);
            populate(root);
        }
        public void populate(Node node){
            System.out.println("Enter left child?");
            boolean left = sc.nextBoolean();
            if(left){
                System.out.println("Enter value of left child of "+node.value);
                int leftval = sc.nextInt();
                node.left = new Node(leftval);
                populate(node.left);
            }

            System.out.println("Enter right child?");
            boolean right = sc.nextBoolean();
            if(right){
                System.out.println("Enter value of right child of "+node.value);
                int rightval = sc.nextInt();
                node.right = new Node(rightval);
                populate(node.right);
            }
        }

        public void display(){
            display(this.root, "");
        }
        public void display(Node node, String indent){
            if(node == null){
                return;
            }
            System.out.println(indent + node.value);
            display(node.left, indent + "\t");
            display(node.right, indent + "\t");
        }

    }

//    public static void main(String[] args) {
//        BinaryTree tree =
//    }
}
