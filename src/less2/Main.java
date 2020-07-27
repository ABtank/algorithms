package less2;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long startTime;
        Random random = new Random();
        int size = 300_000;
        MyArrayList<Integer> mar = new MyArrayList<>();
        mar.add(1);
        mar.add(4);
        mar.add(6);
        mar.add(13);
        System.out.println(mar);

        mar.add(1, 9);
        System.out.println(mar);
        mar.remove(13);
        System.out.println(mar);
        System.out.println(mar.getCapacity());
        mar.add(2);
        mar.add(2);
        mar.add(2);
        mar.add(2);
        mar.add(5);
        System.out.println(mar);
        System.out.println(mar.getCapacity());

        System.out.println(mar.indexOf(3) + " " + mar.contains(3) + " size= " + mar.size());

        System.out.println("Size List = "+size);
        MySortedArrayList<Integer> mySortedArrayList = new MySortedArrayList<>();
        startTime = System.currentTimeMillis();
        fillList(random, mySortedArrayList, size);
        System.out.println("Time filling mySortedArrayList=" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        fillList(random, myArrayList, size);
        System.out.println("Time filling myArrayList=" + (System.currentTimeMillis() - startTime));

        System.out.println("---binaryFind---");
        startTime = System.currentTimeMillis();
        System.out.println("index=" + mySortedArrayList.binaryFind(20) + " Time=" + (System.currentTimeMillis() - startTime));

        System.out.println("---insertionSort---");
        MyArrayList<Integer> insertionSortList = new MyArrayList<>();
        fillList(random, insertionSortList, size);
        startTime = System.currentTimeMillis();
        insertionSortList.insertionSort();
        System.out.println("Time=" + (System.currentTimeMillis() - startTime));

        System.out.println("---selectionSort---");
        MyArrayList<Integer> selectionSortList = new MyArrayList<>();
        fillList(random, selectionSortList, size);
        startTime = System.currentTimeMillis();
        selectionSortList.selectionSort();
        System.out.println("Time=" + (System.currentTimeMillis() - startTime));

        System.out.println("---bubbleSort---");
        MyArrayList<Integer> bubbleSortList = new MyArrayList<>();
        fillList(random, bubbleSortList, size);
        startTime = System.currentTimeMillis();
        bubbleSortList.bubbleSort();
        System.out.println("Time=" + (System.currentTimeMillis() - startTime));

        System.out.println("---newBubbleSort---");
        MyArrayList<Integer> newBubbleSortList = new MyArrayList<>();
        fillList(random, newBubbleSortList, size);
        startTime = System.currentTimeMillis();
        newBubbleSortList.newBubbleSort();
        System.out.println("Time=" + (System.currentTimeMillis() - startTime));

        System.out.println("---newBubbleSortComparator---");
        MyArrayList<Integer> newBubbleSortComparatorList = new MyArrayList<>();
        fillList(random, newBubbleSortComparatorList, size);
        startTime = System.currentTimeMillis();
        newBubbleSortComparatorList.newBubbleSort(Comparator.naturalOrder());
        System.out.println("Time=" + (System.currentTimeMillis() - startTime));

        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        stringMyArrayList.add("AAA");
        stringMyArrayList.add("AAAee");
        stringMyArrayList.add("YYAee");
        stringMyArrayList.add("AdA");
        stringMyArrayList.add("DDD");
        stringMyArrayList.add("eee");
        System.out.println(stringMyArrayList);
        stringMyArrayList.insertionSort(Comparator.naturalOrder());
        System.out.println(stringMyArrayList);
        stringMyArrayList.insertionSort(Comparator.comparingInt(String::length));
        System.out.println(stringMyArrayList);
        stringMyArrayList.insertionSort(Comparator.comparingInt(String::length).reversed());
        System.out.println(stringMyArrayList);
        stringMyArrayList.insertionSort(Comparator.comparingInt(String::length).thenComparing(String::compareToIgnoreCase));
        System.out.println(stringMyArrayList);
    }

    private static void fillList(Random random, MyArrayList<Integer> selectionSortList, int size) {
        for (int i = 0; i < size; i++) {
            selectionSortList.add(random.nextInt(100));
        }
    }
}
