package com.example.datastructures;

public class Queue {
    private SinglyLinkedList list;

    public Queue() {
        list = new SinglyLinkedList();
    }

    void enqueue(int e) {
        list.insertBack(e);
    }

    void dequeue() {
        list.deleteNode(list.getFirst());
    }

    boolean empty() {
        if (list.length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    int front() {
        return list.getFirst();
    }

    int size() {
        return list.length();
    }
}
