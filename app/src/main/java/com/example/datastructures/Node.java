package com.example.datastructures;

public class Node {
    private int data;
    private Node link;

    public Node() {
        data = 0;
        link = null;
    }

    public Node(int data) {
        this.data = data;
        link = null;
    }

    public int getData() {
        return data;
    }

    public Node getLink() {
        return link;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLink(Node node) {
        this.link = node;
    }
}
