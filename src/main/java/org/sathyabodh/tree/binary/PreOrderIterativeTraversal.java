package org.sathyabodh.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterativeTraversal {

    private static void preOrder(Node<Integer> root){
        if(root == null) return ;
        System.out.print (root.data + "->");
        preOrder (root.left);
        preOrder (root.right);
    }

    private static void postOrder(Node<Integer> root){
        if(root == null) return ;
        postOrder (root.left);

        postOrder (root.right);
        System.out.print (root.data + "->");
    }
    private static void inOrder(Node<Integer> root){
        if(root == null) return ;
        inOrder (root.left);
        System.out.print (root.data + "->");
        inOrder (root.right);
    }

    private static List<Integer> preOrdertIteratvie(Node<Integer> root){
        List<Integer> preOrderList = new ArrayList<> ();
        Stack<Node<Integer>> stack = new Stack<> ();
        Node<Integer> current = root;
        stack.push (root);
        while(!stack.isEmpty ()){
            current = stack.pop ();
            System.out.print(current.data + "->");
            preOrderList.add (current.data);
            if(current.right != null)
                stack.push (current.right);
            if(current.left != null)
                stack.push (current.left);
        }
        System.out.println();
        return  preOrderList;
    }

    static List<Integer> inOrderIterative(Node<Integer> root){
        List<Integer> inorder = new ArrayList<> ();
        Stack<Node<Integer>> stack =  new Stack<> ();
        stack.push (root);
        Node<Integer> current = root;
        while(!stack.isEmpty ()){
            Node<Integer> stackTop = stack.peek ();
            if(current != null && current.left != null)
            {
                stack.push (current.left);
                current = current.left;
            }
            else{
                stackTop = stack.pop ();
                System.out.print(stackTop.data + "->");
                inorder.add (stackTop.data);
                if(stackTop.right != null){
                    current = stackTop.right;
                    stack.push (current);
                }
            }
        }
        return  inorder;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<> (1);
        Node<Integer> node1 = new Node<> (2);
        Node<Integer> node2 = new Node<> (3);
        root.setLeft (node1);
        root.setRight (node2);

        Node<Integer> node3 = new Node<> (4);
        Node<Integer> node4 = new Node<> (5);
        node1.setLeft (node3);
        node1.setRight (node4);

        Node<Integer> node5 = new Node<> (6);
        node4.setLeft (node5);

        Node<Integer> node6 = new Node<> (7);
        node2.setRight (node6);
        Node<Integer> node7 = new Node<> (8);
        node6.setRight (node7);

        System.out.println ("PreOrder Recursive");
        preOrder(root);
        System.out.println ();
        List<Integer> postOrder = preOrdertIteratvie (root);
        System.out.println ("PreOrder: " + postOrder.toString ());

        System.out.println ("Inorder Recursive");
        inOrder (root);
        System.out.println ();
        List<Integer> inOrder = inOrderIterative (root);
        System.out.println ("InOrder: " + inOrder.toString ());

    }
}
