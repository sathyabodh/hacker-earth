package org.sathyabodh.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderPrinting {
    static void spiralPrint(Node<Integer> root){
        Stack<Node<Integer>> LTRStack = new Stack<> ();
        Stack<Node<Integer>> RTLStack = new Stack<> ();
        boolean ltr=true;
        LTRStack.push (root);
        while(!LTRStack.isEmpty () || !RTLStack.isEmpty ()){
            if(ltr){
                ltr=false;
                while(!LTRStack.isEmpty ()){
                    Node<Integer> node = LTRStack.pop ();
                    if(node.left != null)
                        RTLStack.push(node.left);
                    if(node.right != null)
                        RTLStack.push (node.right);

                    System.out.print (node.data + "->");
                }

            }
            else {
                ltr=true;
                while(!RTLStack.isEmpty ()){
                    Node<Integer> node = RTLStack.pop ();
                    if(node.right != null)
                        LTRStack.push(node.right);
                    if(node.left != null)
                        LTRStack.push (node.left);
                    System.out.print (node.data + "->");
                }

            }

        }
    }

    public static void main(String[] args) {
        Node<Integer> root = constructTree (17);
        spiralPrint (root);
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
        return root;
    }
}
