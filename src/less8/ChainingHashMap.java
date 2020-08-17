package less8;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * метод цепочек
 */
public class ChainingHashMap<Key, Value> {
    private int capacity;
    private int size;

    private LinkedList<Node>[] st;

    public ChainingHashMap() {
        this.capacity = 8;
        st = new LinkedList[capacity];  // лист элементов
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity; // & побитовое умножение
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    //вставка
    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    //получение
    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public Value delete(Key key) {
        checkKeyNotNull(key);
        Value temp = get(key);
        if (temp == null) {
            return null;
        }
        int i = hash(key);
        st[i].removeIf(node -> node.key.equals(key));
        size--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(" ").append(node.value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
