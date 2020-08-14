package less8;

import java.util.LinkedList;

public class LinearProbingHashMap<Key, Value> {
    private int capacity; // при открытой адресации размер массива всегда простое число
    private int size;

    private final Key DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap() {
        capacity = 19;
        this.keys = (Key[]) new Object[capacity];
        this.values = (Value[]) new Object[capacity];
        DELETED = (Key) new Object();
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

    public int hash2(Key key){
        return 7-(key.hashCode() & 0x7fffffff) % 7;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        int checkNum = hash(key);
        int step = hash2(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + step) % capacity; //если дошли до конца и начать искать по кругу
            if(i == checkNum) break; // если мы обошли весь массив
        }
        return null;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        if (size == capacity - 1) {
            throw new RuntimeException("Места не осталось");
        }
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null && keys[i].equals(DELETED)) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            i = (i + step) % capacity; //если дошли до конца и начать искать по кругу
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public void delete(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = DELETED;
                values[i] = null;
                size--;
                return;
            }
            i = (i + step) % capacity; //если дошли до конца и начать искать по кругу
        }
    }
}
