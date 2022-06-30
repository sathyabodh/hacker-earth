package org.sathyabodh.tree.binary;

public class Node<T> {
    T data;
    Node<T> left = null;
    Node<T> right = null;
    Node(T data){
        this(data, null, null);
    }

    Node(T data, Node<T> left, Node<T> right){
        this.data = data;
        setLeft (left);
        setRight (right);
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }
}
