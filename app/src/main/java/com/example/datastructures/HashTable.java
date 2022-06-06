package com.example.datastructures;

public class HashTable {
    private Record[] table;
    int capacity;
    int used;

    HashTable() {
        capacity = 200000;
        used = 0;
        table = new Record[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    void insert(long key, int data) {
        long absoluteValueOfKey = calculateAbsoluteValue(key);
        int hashValue = (int)(absoluteValueOfKey % capacity);
        if (table[hashValue] == null) {
            Record record = new Record(key, data);
            table[hashValue] = record;
            used++;
            return;
        }
        else {
            for (int j = 0; j < capacity; j++) {
                int hashValuePrime = 7 - (int)(absoluteValueOfKey % 7);
                hashValue = (hashValue + j * hashValuePrime) % capacity;
                if (table[hashValue] == null) {
                    Record record = new Record(key, data);
                    table[hashValue] = record;
                    used++;
                    return;
                }
            }

            int oldCapacity = capacity;
            capacity = oldCapacity * 2;

            Record[] oldTable = table;
            table = new Record[capacity];

            for (int i = 0; i < capacity; i++) {
                table[i] = null;
            }

            for (int i = 0; i < oldCapacity; i++) {
                if (oldTable[i] == null) {

                }
                else {
                    insert(oldTable[i].getKey(), oldTable[i].getData());
                }
            }

            insert(key, data);
        }
    }

    void remove(long key) {
        long absoluteValueOfKey = calculateAbsoluteValue(key);
        int hashValue = (int) (absoluteValueOfKey % capacity);
        if (table[hashValue] == null) {
            return;
        }
        else if (table[hashValue].getKey() == key) {
            if (table[hashValue].getDeleted() == true) {
                return;
            }
            else {
                table[hashValue].setDeleted(true);
                used--;
                return;
            }
        }
        else {
            for (int j = 0; j < capacity; j++) {
                int hashValuePrime = 7 - (int) (absoluteValueOfKey % 7);
                hashValue = (hashValue + j * hashValuePrime) % capacity;
                if (table[hashValue] == null) {
                    return;
                }
                else if (table[hashValue].getKey() == key) {
                    if (table[hashValue].getDeleted() == true) {
                        return;
                    }
                    else {
                        table[hashValue].setDeleted(true);
                        used--;
                        return;
                    }
                }
            }
        }
    }

    boolean search(long key) {
        long absoluteValueOfKey = calculateAbsoluteValue(key);
        int hashValue = (int) (absoluteValueOfKey % capacity);
        if (table[hashValue] == null) {
            return false;
        }
        else if (table[hashValue].getKey() == key) {
            if (table[hashValue].getDeleted() == true) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            for (int j = 0; j < capacity; j++) {
                int hashValuePrime = 7 - (int) (absoluteValueOfKey % 7);
                hashValue = (hashValue + j * hashValuePrime) % capacity;
                if (table[hashValue] == null) {
                    return false;
                }
                else if (table[hashValue].getKey() == key) {
                    if (table[hashValue].getDeleted() == true) {
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    Integer getData(long key) {
        long absoluteValueOfKey = calculateAbsoluteValue(key);
        int hashValue = (int) (absoluteValueOfKey % capacity);
        if (table[hashValue] == null) {
            return null;
        }
        else if (table[hashValue].getKey() == key) {
            if (table[hashValue].getDeleted() == true) {
                return null;
            }
            else {
                return table[hashValue].getData();
            }
        }
        else {
            for (int j = 0; j < capacity; j++) {
                int hashValuePrime = 7 - (int) (absoluteValueOfKey % 7);
                hashValue = (hashValue + j * hashValuePrime) % capacity;
                if (table[hashValue] == null) {
                    return null;
                }
                else if (table[hashValue].getKey() == key) {
                    if (table[hashValue].getDeleted() == true) {
                        return null;
                    }
                    else {
                        return table[hashValue].getData();
                    }
                }
            }

            return null;
        }
    }

    int size() {
        return used;
    }

    private long calculateAbsoluteValue(long key) {
        if (key < 0) {
            return key * -1;
        }
        else {
            return key;
        }
    }
}
