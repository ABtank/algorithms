package less6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int hight;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.hight = 0;
        }
    }

    //  размер всего дерева
    public int size() {
        return size(root);
    }

    //     возврат размера текущего узла
    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int hight() {
        return hight(root);
    }

    private int hight(Node node) {
        if (node == null) return 0;
        return node.hight;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        return true;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    //  возврат значения по ключу
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * @param node с какого узла начинать искать
     * @param key  какое значение ищем
     */
    private Value get(Node node, Key key) {
        isKeyNotNull(key);
//        БАЗОВЫЙ СЛУЧАЙ
        if (node == null) return null; // некуда больше идти

        int cmp = key.compareTo(node.key); //   -1 0 1
        if (cmp == 0) return node.value; // нашли
        else if (cmp < 0) {
            return get(node.left, key); // ищи слева
        } else {
            return get(node.right, key); // ищи справа
        }
    }

    //    вставка ключа и значения
    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete(key)
            return;
        }
        //рекурентноприватный метод
        root = put(root, key, value); // обновить ссылку root на то дерево которое вернеться после вставки
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {                        // если дошли по дереву в конец
            return new Node(key, value);           // вставляем
        }
//        сравнение ключей
        int cmp = key.compareTo(node.key);
        if (cmp == 0) node.value = value;       // если ключи совпали заменяем значение
        else if (cmp < 0) {  // если наш ключь меньше
            node.left = put(node.left, key, value); // обновляем дерево слева
        } else {
            node.right = put(node.right, key, value); // обновляем дерево справа
        }
//        Расчет уровня узла
        node.size = size(node.left) + size(node.right) + 1;
        node.hight = Math.max(hight(node.left), hight(node.right)) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    public boolean isBalansed() {
        return isBalansed(root);
    }

    private boolean isBalansed(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right ==null) return true;
        if (Math.abs(hight(node.left)- hight(node.right)) > 1) return false;
        isBalansed(node.left);
        isBalansed(node.right);
        return true;
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;   // не нашли
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key); // обновляем дерево слева
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right); //ссылайся на мин элемент правого узла
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.hight = Math.max(hight(node.left), hight(node.right)) + 1;
        return node;

    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right; // если нашли min то просто возвращаем правое дерево минимального значения
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.hight = Math.max(hight(node.left), hight(node.right)) + 1;
        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node);
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) return "";
        return toString(node.left) + " " + node.key + "=" + node.value + " size=" + node.size +" hight=" + node.hight + " " + toString(node.right);
    }
}
