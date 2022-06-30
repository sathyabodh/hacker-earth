package org.sathyabodh.tree.binary;

public class HeightOfBinaryTree {
    static int height(Node<Integer> root, int height){
        if(root == null){
            return height;
        }
        int leftH = height(root.left, height);
        int rightH = height(root.right, height);
        return Math.max(leftH, rightH) + 1;
    }
    public static void main(String[] args) {
        Node<Integer> root = constructTree (17);
        int nodeCount = height (root, 0);
        System.out.println ("Height of BTree " + nodeCount);
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
        return root;
    }

}
