package org.sathyabodh.tree.binary;

public class IsSameBinaryTree {
    static boolean isSame(Node<Integer> root1, Node<Integer> root2){
        if(root1 != null && root2 == null)
            return false;
        else if(root1 == null && root2 != null)
            return false;
        else if(root1 == null && root2 == null)
            return true;
        else {
            boolean isSameTree = false;
            if(root1.data == root2.data) {
                isSameTree = isSame (root1.left, root2.left);
                if(isSameTree)
                    isSameTree = isSame(root1.right, root2.right);
            }
            return isSameTree;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root1 = constructTree(17);

        Node<Integer> root2 = constructTree (17);
        boolean isSameTree = isSame (root1, root2);
        System.out.println ("Is same BST: " + isSameTree);

        root2 = constructTree (16);
        isSameTree = isSame (root1, root2);
        System.out.println ("Is same BST: " + isSameTree);

        Node<Integer> root = new Node<> (10);
        Node<Integer> node1 = new Node<> (-10);
        Node<Integer> node2 = new Node<> (19);
        root.setLeft (node1);
        root.setRight (node2);

        isSameTree = isSame (root1, root);
        System.out.println ("Is same BST: " + isSameTree);

        isSameTree = isSame (root, root1);
        System.out.println ("Is same BST: " + isSameTree);
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
