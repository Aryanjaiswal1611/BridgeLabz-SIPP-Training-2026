

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


class Node{
    char data;
    Node left;
    Node right;
    Node(char data){
        this.data=data;
        this.left=null;
        this.right= null;
    }
}

public class tree {

    public static void preOrder(Node root){
        if(root==null) return ;
        System.out.println("preOrder - " + root.data);

        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null) return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("post order- "+ root.data);
    }
    public static void inOrder(Node root){
        if(root==null) return ;
        inOrder(root.left);
        System.out.println("Inorder order- "+ root.data);
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node ele = q.poll();
            System.out.println(ele.data+" ");
            if(ele.left!=null) q.offer(ele.left);
            if(ele.right!=null) q.offer(ele.right);

        }
    }


    public static void main(String[] args) {

//level 1
        Node root = new Node('A');
//        level 2
        root.left = new Node('B');
        root.right = new Node('C');

//        level 3
        root.left.left = new Node('D');
        root.left.right= new Node ('E');
        root.right.left = new Node('G');
        root.right.right =new Node('H');
//        level4
        root.left.right.left = new Node ('I');
        root.left.right.right = new Node ('J');

        root.right.left.left = new Node('K');


        //calling
       postOrder(root);
       postOrder(root);
       inOrder(root);
        levelOrder(root);

    }
}
