package org.sathyabodh.tree.binary;

public class LowestCommonAncestor {
    static Node<Integer> lowestCommonAncestor(Node<Integer> root, int val1, int val2){
        Node<Integer> node = null;
        if(root == null)
            return null;
        if(root.data == val1 || root.data == val2){
            return root;
        }
        Node<Integer> node1 = lowestCommonAncestor (root.left, val1, val2);
        Node<Integer> node2 = lowestCommonAncestor (root.right, val1, val2);
        if(node1 != null && node2 != null){
            return root;
        }
        if(node1 != null){
            return node1;
        }
        else{
            return node2;
        }
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

        Node<Integer> node = lowestCommonAncestor (root, 4, 7);
        System.out.println ("LCW for node 4 and 7 is:" + node.data);


        node = lowestCommonAncestor (root, 4, 6);
        System.out.println ("LCW for node 4 and 6 is:" + node.data);


        node = lowestCommonAncestor (root, 7, 8);
        System.out.println ("LCW for node 7 and 8 is:" + node.data);

        node = lowestCommonAncestor (root, 5, 6);
        System.out.println ("LCW for node 5 and 6 is:" + node.data);

    }
}
