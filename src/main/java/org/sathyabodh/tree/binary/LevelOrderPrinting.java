package org.sathyabodh.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderPrinting {
    static void levelPrinting(Node<Integer> root){
        Queue<Node<Integer>> queue = new ArrayDeque<> ();
        queue.add (root);
        while(!queue.isEmpty ()){
            int queueSize = queue.size ();
            while(queueSize >0){
                Node<Integer> node = queue.poll ();
                System.out.print(node.data + "->");
                queueSize--;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println ();
        }
    }
    public static void main(String[] args) {
        Node<Integer> root = constructTree (17);
        levelPrinting (root);

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
