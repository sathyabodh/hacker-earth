package org.sathyabodh.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterativeTraversal {

    static List<Integer> postOrdertIteratvie(Node<Integer> root){
        List<Integer> postorder = new ArrayList<> ();
        Stack<Node<Integer>> stack = new Stack<> ();
        Node<Integer> current = root;
        while(current != null || !stack.isEmpty ()){
            if(current == null){
                Node<Integer> stackTop = stack.peek ();
                if(stackTop.right != null){
                    current = stackTop.right;
                }
                else{
                    Node<Integer> popped = stack.pop ();
                    System.out.print(popped.data + "->");
                    postorder.add (popped.data);
                    while(!stack.isEmpty () && stack.peek ().right == popped){
                        popped = stack.pop ();
                        postorder.add (popped.data);
                        System.out.print(popped.data + "->");
                    }
                }
            }
            else if(current.left != null){
                stack.push (current);
                current = current.left;
            }
            else if(current.right != null){
                stack.push (current);
                current = current.right;
            }
            else{
                stack.push (current);
                current = null;
            }
        }
        System.out.println();
        return  postorder;
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

        List<Integer> postOrder = postOrdertIteratvie (root);
        System.out.println ("PostOrder: " + postOrder.toString ());

    }
}
