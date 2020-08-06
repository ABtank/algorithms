package less6;

import java.util.Random;

public class Main6 {

    public static void main(String[] args) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(5, "five");
        map.put(1, "one");
        map.put(3, "three");
        map.put(2, "two");

        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map.get(22));
        map.put(2, "два");
        System.out.println(map);
        map.deleteMin();
        System.out.println(map);

    }
}
