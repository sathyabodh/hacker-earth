package org.sathyabodh.tree.binary;

public class RootToLeaftSumTree {
    static boolean isSumEqualToRootToLeafPathExists(Node<Integer> root, int sum){
        if(root == null){
            return false;
        }
        sum -= root.data;
        if(sum == 0 && root.left == null && root.right == null)
            return true;
        return isSumEqualToRootToLeafPathExists (root.left, sum) || isSumEqualToRootToLeafPathExists (root.right, sum);
    }

    public static void main(String[] args) {
        Node<Integer> root = constructTree ();
        boolean isExists = false;
        isExists = isSumEqualToRootToLeafPathExists (root, 26);
        System.out.println ("Sum= 26 Exists: " + isExists);
        isExists = isSumEqualToRootToLeafPathExists (root, 23);
        System.out.println ("Sum=23 Exists: " + isExists);
        isExists = isSumEqualToRootToLeafPathExists (root, 15);
        System.out.println ("Sum=15 Exists: " + isExists);
    }
    private static Node<Integer> constructTree(){
        Node<Integer> root = new Node<> (10);
        Node<Integer> node1 = new Node<> (16);
        Node<Integer> node2 = new Node<> (5);
        root.setLeft (node1);
        root.setRight (node2);

        Node<Integer> node3 = new Node<> (-3);
        node1.setRight (node3);

        Node<Integer> node4= new Node<> (6);
        Node<Integer> node5= new Node<> (11);
        node2.setLeft (node4);
        node2.setRight (node5);
        return root;
    }
}
