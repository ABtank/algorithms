package less2;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkCorrectIndex(index);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public boolean remove(T item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) return false;
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public T get(int index) {
        checkCorrectIndex(index);
        return list[index];
    }

    public void set(int index, T item) {
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void selectionSort(){
        for (int i = 0; i <size-1 ; i++) {
            int min = i;
            for (int j = i+1; j <size ; j++) {
                if(less(list[j],list[min])){
                    min =j;
                }
            }
            swap(i,min);
        }
    }

    public void insertionSort(){
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j>0 && less(key, list[j-1])){
                list[j]=list[j-1];
                j--;
            }
            list[j]=key;
        }
    }

    public void bubbleSort(){
        for (int i = size-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(less(list[j+1],list[j])){
                    swap(j+1,j);
                }
            }
        }
    }

    private void checkCorrectIndex(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("invalid index=" + index);
        }
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
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
