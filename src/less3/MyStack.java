package less3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyStack(int capacity) {
        this.capacity = capacity;
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0" + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void push(T item) {
        if (isFull()) {
            expandCapacity(capacity);
        }
        list[size] = item;
        size++;
        expandCapacity(capacity);
    }

    //    достаем
    public T pop() {
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

    private void reCapacity(int newCapacity){
        T [] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }

    private void expandCapacity(int oldCapacity) {
        if (size > oldCapacity * 0.75) {
            int newCapacity = list.length + (list.length >> 1);
            if (newCapacity - list.length < 0) newCapacity = MAX_ARRAY_SIZE;
            capacity = newCapacity;
            list = Arrays.copyOf(list, newCapacity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i <size; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(" ]");
        return sb.toString();
    }
}
