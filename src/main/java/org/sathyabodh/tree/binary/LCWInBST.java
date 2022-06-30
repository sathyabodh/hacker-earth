package org.sathyabodh.tree.binary;

public class LCWInBST {
    static Node<Integer> lcw(Node<Integer> root, int val1, int val2){
        if(root == null)
            return null;
        if(root.data == val1 || root.data == val2)
            return root;
        Node<Integer> node1 = null;
        if(root.data < val1 || root.data < val2){
            node1 = lcw (root.right, val1, val2);
        }
        Node<Integer> node2 = null;
        if(root.data > val1 || root.data > val2){
            node2 = lcw (root.left, val1, val2);
        }
        if(node1 != null && node2 != null)
            return root;
        if(node1 != null)
            return node1;
        else
            return node2;
    }
    public static void main(String[] args) {
        Node<Integer> root = constructTree ();
        findLCW (root, 28,78);
        findLCW (root, 6,30);
        findLCW (root, 30,78);
    }
    static void findLCW(Node<Integer> root, int val1, int val2){
        Node<Integer> node = lcw (root, val1,val2);
        System.out.printf ("LCW for %d and %d is %d\n", val1, val2, node.data);
    }
    private static Node<Integer> constructTree() {
        Node<Integer> root = new Node<> (10);
        Node<Integer> node1 = new Node<> (-10);
        Node<Integer> node2 = new Node<> (30);
        root.setLeft (node1);
        root.setRight (node2);

        Node<Integer> node3 = new Node<> (8);
        node1.setRight (node3);

        Node<Integer> node4 = new Node<> (25);
        Node<Integer> node5 = new Node<> (60);
        node2.setLeft (node4);
        node2.setRight (node5);

        Node<Integer> node6 = new Node<> (6);
        Node<Integer> node7 = new Node<> (9);
        node3.setLeft (node6);
        node3.setRight (node7);


        Node<Integer> node8 = new Node<> (28);
        node4.setRight (node8);


        Node<Integer> node9 = new Node<> (78);
        node5.setRight (node9);

        return root;
    }
}
