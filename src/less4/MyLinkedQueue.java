package less4;

public class MyLinkedQueue<T> {
    MyDoLinkedList<T> queue = new MyDoLinkedList<>();

    public void insert(T item) {
        queue.insertFirst(item);
    }

    public T peek() {
        return queue.getLast();
    }

    public T remove() {
        return queue.deleteLast();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
