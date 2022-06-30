package org.sathyabodh.tree.binary;

public class IsBST {

    static Node isBST(Node<Integer> root, Node<Integer> prev){
        if(root == null)
            return prev;
        prev = isBST (root.left, prev);
        if(prev == null || prev.data < root.data){
            prev = root;
        }
        else{
            throw new RuntimeException ("Not BST because " + prev.data + ">" + root.data);
        }
        prev = isBST (root.right, prev);

        return prev;
    }
    public static void main(String[] args) {
        Node<Integer> root = new Node<> (10);
        Node<Integer> node1 = new Node<> (-10);
        Node<Integer> node2 = new Node<> (19);
        root.setLeft (node1);
        root.setRight (node2);

        Node<Integer> node3 = new Node<> (-20);
        Node<Integer> node4 = new Node<> (0);
        node1.setLeft (node3);
        node1.setRight (node4);

        Node<Integer> node5= new Node<> (17);
        node2.setLeft (node5);

        Node<Integer> node = isBST(root, null);
        System.out.println ("Max Node:" + node.data);

        //Modifying the Node4
        node4.setData (14);
        node = isBST(root, null);
        System.out.println ("Max Node:" + node.data);

    }
}
