package com.example.datastructures;

public class Record {
    private long key;
    private int data;
    private boolean deleted;

    Record() {
        key = 0;
        data = 0;
        deleted = false;
    }

    Record(long key, int data) {
        this.key = key;
        this.data = data;
        deleted = false;
    }

    long getKey() {
        return key;
    }

    int getData() {
        return data;
    }

    boolean getDeleted() { return deleted; }

    void setKey(long key) {
        this.key = key;
    }

    void setData(int data) {
        this.data = data;
    }

    void setDeleted(boolean deleted) { this.deleted = deleted; }
}