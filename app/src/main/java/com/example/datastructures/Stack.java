package com.example.datastructures;

public class Stack {
    private SinglyLinkedList list;

    public Stack() {
        list = new SinglyLinkedList();
    }

    void push(int e) {
        list.insertFront(e);
    }

    void pop() {
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

    int top() {
        return list.getFirst();
    }

    int size() {
        return list.length();
    }
}
