package org.sathyabodh.tree.binary;

public class SizeOfBinaryTree {
    static int size(Node<Integer> root, int nodeCount){
        if(root == null)
            return nodeCount;
        nodeCount = size(root.left, nodeCount);
        nodeCount+=1;
        nodeCount = size(root.right, nodeCount);
        return nodeCount;
    }
    public static void main(String[] args) {
        Node<Integer> root = constructTree (17);
        int nodeCount = size (root, 0);
        System.out.println ("Size of BTree " + nodeCount);
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
        return root;
    }
}
