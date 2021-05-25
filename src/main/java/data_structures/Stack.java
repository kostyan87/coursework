package data_structures;

public class Stack<T> {

    private LinkedList<T> stackList = new LinkedList<>();

    public int getSize() {
        return stackList.getSize();
    }

    public void push(T value) {
        stackList.pushBack(value);
    }

    public T pop() {
        return stackList.popBack();
    }

    public T getTop() {
        return stackList.getTail();
    }

    public void printStack() {
        stackList.printList();
    }
}
