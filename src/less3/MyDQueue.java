package less3;

import java.util.EmptyStackException;

public class MyDQueue<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;


    public MyDQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0" + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    //  Смотрим первый добавленый
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeRight() {
        T temp = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public T removeLeft() {
        end = prevIndex(end);
        T temp = list[end];
        size--;
        list[end] = null;
        return temp;
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

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        int a = (index - 1) % list.length;
        return (a < 0) ? list.length : a;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (!isEmpty()) {
            int i = begin;
            while (i != end) {
                sb.append(list[i]).append(", ");
                i = nextIndex(i);
            }
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        return sb.toString();
    }
}
