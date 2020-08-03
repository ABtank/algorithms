package less4;

import java.util.Iterator;
import java.util.ListIterator;

public class MyDoLinkedList<T> {

    private Node first;
    private Node last;
    private int size;

    public MyDoLinkedList() {
        this.first = null;
        this.last = null;
    }


    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private class ListIter implements ListIterator<T> {
        Node nextNode = first;
        Node prevNode = null;
        int index = -1;
        boolean lastOperationIsNext;


        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T temp = nextNode.value;
            prevNode = nextNode;
            nextNode = nextNode.next;
            index++;
            lastOperationIsNext = true;
            return temp;
        }

        @Override
        public boolean hasPrevious() {
            return prevNode != null;
        }

        @Override
        public T previous() {
            T temp = prevNode.value;
            nextNode = prevNode;
            prevNode = prevNode.previous;
            index--;
            lastOperationIsNext = false;
            return temp;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index;
        }

        @Override
        public void remove() {
//            Удалить элемент на который указывает prevNode
            if (lastOperationIsNext) {
                if (!hasNext()) {
                    deleteLast();
                    nextNode = null;
                    prevNode = last;
                    return;
                }
                nextNode.previous = prevNode.previous;
                if (prevNode.previous != null) {
                    prevNode.previous.next = nextNode;
                }
                prevNode = nextNode.previous;
            } else {
//                Удалить элемент на который указывает nextNode
                if (!hasNext()) {
                    deleteFirst();
                    prevNode = null;
                    nextNode = first;
                    return;
                }
                prevNode.next = nextNode.next;
                if(nextNode.next !=null){
                    nextNode.next.previous = prevNode;
                }
                nextNode= prevNode.next;
            }
        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    // указатель
    private class Node {
        T value;
        Node next;
        Node previous;

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    //вставка в начало списка
    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }

    //вставка в конец списка
    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    //вставка по индексу
    public void insert(int index, T item) {
        if (index < 0 && index > size) {
            throw new RuntimeException("Incorrect index = " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        Node corrent = first;
        int i = 0;
        //остановимся на элементе после которого будет вставлен элемент
        while (i < index - 1) {
            corrent = corrent.next;
            i++;
        }
        // создаем узел и говорим что он указывает на след элемент
        Node newNode = new Node(item, corrent.next); // ->
        // а предыдущий у тебя такой
        newNode.previous = corrent; // <-
        // говорим предыдущему что он указывает на новый элемент
        corrent.next = newNode; // <-
        // говорим след элементу что предыдущий это наш новый
        newNode.next.previous = newNode; // ->
        size++;
    }

    // удаление первого элемента
    public T deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return oldFirst.value;
    }

    public T deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node oldLast = last;
        if (last.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        size--;
        return oldLast.value;
    }

    //удаление по значению T
    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            deleteFirst();
            return true;
        }
        Node current = first;
        //пока следующий элемент не нулл и не равен искомому обьекту
        while (current != null && !current.value.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            deleteLast();
            return true;
        }
        current.previous.next = current.next; // ->
        current.next.previous = current.previous; // <-
        size--;
        return true;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return last.value;
    }

    //номер индекса по объекту
    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.next;
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
