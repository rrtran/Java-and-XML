package com.example.datastructures;

public class SinglyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public SinglyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void insertFront(int data) {
        if (size == 0) {
            Node node = new Node(data);
            first = node;
            last = node;
            size++;
            return;
        }
        else {
            Node node = new Node(data);
            node.setLink(first);
            first = node;
            size++;
            return;
        }
    }

    public void insertBack(int data) {
        if (size == 0) {
            Node node = new Node(data);
            first = node;
            last = node;
            size++;
            return;
        }
        else {
            Node node = new Node(data);
            last.setLink(node);
            last = node;
            size++;
            return;
        }
    }

    public void deleteNode(int data) {
        if (size == 0) {
            return;
        }
        else if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }
        else {
            Node trailCurrent = null;
            Node current = first;
            while (current != null) {
                if (current.getData() == data) {
                    if (current == first) {
                        first = first.getLink();
                        current = null;
                        size--;
                        return;
                    }
                    else if (current == last) {
                        trailCurrent.setLink(null);
                        last = trailCurrent;
                        current = null;
                        size--;
                        return;
                    }
                    else {
                        trailCurrent.setLink(current.getLink());
                        current = null;
                        size--;
                        return;
                    }
                }
                trailCurrent = current;
                current = current.getLink();
            }
        }
    }

    public int getFirst() {
        return first.getData();
    }

    public int length() {
        return size;
    }
}
