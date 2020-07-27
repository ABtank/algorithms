package less3;

import java.util.Comparator;
import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Comparator comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0" + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue(int capacity, Comparator comparator) {
        this.comparator =comparator;
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0" + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public MyPriorityQueue(Comparator comparator) {
        this.comparator =comparator;
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void insert(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while (i > 0 && comparator.compare(list[i],list[i - 1]) > 0) {
            swap(i, i - 1);
            i--;
        }
    }

    public T remove() {
        T item = peek();
        size--;
        list[size] = null;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        return sb.toString();
    }
}
