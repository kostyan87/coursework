package data_structures;

public class Queue<T> {

    private LinkedList<T> queueList = new LinkedList<>();

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public void push(T value) {
        queueList.pushFront(value);
    }

    public T pop() {
        return queueList.popBack();
    }

    public T getTop() {
        return queueList.getTail();
    }

    public void printQueue() {
        queueList.printList();
    }
}
