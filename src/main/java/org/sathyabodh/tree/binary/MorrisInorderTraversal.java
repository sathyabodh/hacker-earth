package org.sathyabodh.tree.binary;

public class MorrisInorderTraversal {
    static void morrisInorder(Node<Integer> root){
        Node<Integer> current = root;
        while(current != null){
            if(current.left != null){
                Node<Integer> temp = current.left;
                while(temp.right != null && temp.right != current){
                    temp = temp.right;
                }
                if(temp.right == current){
                    temp.right = null;
                    System.out.print (current.data + "->");
                    current = current.right;
                }
                else{
                    temp.right = current;
                    current = current.left;
                }
            }
            else{
                System.out.print (current.data + "->");
                current = current.right;
            }


        }

    }

    static void morrisPreOrder(Node<Integer> root){
//        Node<Integer> current = root;
//        while(current != null){
//            System.out.print(current.data + "->");
//            if(current.left != null){
//                Node<Integer> temp  = current.left;
//                while(temp.right != null || temp.left != null){
//                    if(temp.right != null)
//                        temp = temp.right;
//                    else if(temp.left != null){
//                        temp = temp.left;
//                    }
//                }
//                if(current.right != null){
//                    temp.right = current.right;
//
//                }
//                current = current.left;
//            }
//            else{
//                current = current.right;
//            }
//        }
        Node<Integer> current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data + "->");
                current = current.right;
            }
            else if (current.left != null){
                Node<Integer> temp = current.left;
                while(temp.right != null && temp.right != current){
                    temp = temp.right;
                }
                if(temp.right == current){
                    temp.right = null;
                    current = current.right;
                }
                else if(temp.right == null){
                    temp.right = current;
                    System.out.print(current.data + "->");
                    current = current.left;
                }
            }
        }
        System.out.println ();
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

        morrisInorder (root);

        System.out.println ();
        System.out.println ("Pre-order");
        morrisPreOrder (root);
    }
}
