package data_structures;

public class LinkedList<T> {

    private int size = 0;

    private Node<T> head = null;

    private Node<T> tail = null;

    public int getSize() {
        return size;
    }

    public T getTail() {
        return tail.value;
    }

    public int indexOf(T value) {

        Node<T> listElem = head;

        for (int i = 0; i < getSize(); i++) {
            if (listElem.value == value) return i;
            listElem = listElem.next;
        }

        return -1;
    }

    public T get(int index) {
        if (index > getSize() || index < 0)
            throw new RuntimeException("Incorrect index");

        if (isEmpty()) throw new RuntimeException("The list is empty");

        Node<T> listElem = head;

        for (int i = 0; i < getSize(); i++) {
            if (i == index) return listElem.value;
            listElem = listElem.next;
        }

        return null;
    }

    public boolean has(T elem) {
        Node<T> listElem = head;

        for (int i = 0; i < getSize(); i++) {
            if (listElem.value.equals(elem)) return true;
            listElem = listElem.next;
        }

        return false;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void pushFront(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void pushBack(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            newNode.next = null;
        }
    }

    public T popBack() {
        if (isEmpty()) throw new RuntimeException("The list is empty");

        T lastNodeValue = tail.value;

        if (getSize() == 1) {
            head = null;
            tail = null;
            size--;
        }
        else {
            tail.prev.next = null;
            tail = tail.prev;
            size--;
        }

        return lastNodeValue;
    }

    public void printList() {
        if (isEmpty()) System.out.println("The list is Empty");
        else {
            Node<T> listElem = head;
            String stringOfList = "[";

            for (int i = 0; i < getSize(); i++) {
                stringOfList += listElem.value + " ";
                listElem = listElem.next;
            }

            System.out.println(stringOfList + "]");
        }
    }

    static class Node<T> {

        private T value; // T = (RBTreeMap) Node<K, V>

        private Node<T> next = null;

        private Node<T> prev = null;

        public Node(T value) {
            this.value = value;
        }
    }
}
