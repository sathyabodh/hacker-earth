package org.sathyabodh.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseOrderPrinting {
    static void reverseOrderPrint(Node<Integer> root){
        Queue<Node<Integer>> queue = new ArrayDeque<> ();
        Stack<Node<Integer>> stack = new Stack<> ();
        queue.add(root);
        while(!queue.isEmpty ()){
            Node<Integer> node = queue.poll ();
            stack.push (node);
            if(node.right != null){
                queue.add(node.right);
            }
            if(node.left != null){
                queue.add(node.left);
            }
        }
        while(!stack.isEmpty ()){
            Node<Integer> node = stack.pop ();
            System.out.print(node.data + "->");
        }
        System.out.println ();
    }
    public static void main(String[] args) {
        Node<Integer> root = constructTree (17);
        reverseOrderPrint (root);
    }
    private static Node<Integer> constructTree(int lastNode){
        Node<Integer> root = new Node<> (10);
        Node<Integer> node1 = new Node<> (-10);
        Node<Integer> node2 = new Node<> (19);
        root.setLeft (node1);
        root.setRight (node2);

        Node<Integer> node3 = new Node<> (-20);
        Node<Integer> node4 = new Node<> (0);
        node1.setLeft (node3);
        node1.setRight (node4);

        Node<Integer> node5= new Node<> (lastNode);
        node2.setLeft (node5);

        Node<Integer> node6= new Node<> (16);
        node5.setLeft (node6);
        Node<Integer> node7= new Node<> (11);
        node5.setRight (node7);

        Node<Integer> node8 = new Node<> (25);
        node6.setRight (node8);
        return root;
    }

}
