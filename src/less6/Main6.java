package less6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main6 {
    private static int balans = 0;
    private static int noBalans = 0;
    static final Random random = new Random();

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

        MyTreeMap<String, String> maps = new MyTreeMap<>();
        String str = "SEARCHXYZ";
        for (int i = 0; i < str.length(); i++) {
            maps.put(String.valueOf(str.charAt(i)), String.valueOf(str.charAt(i)));
        }
        infoMap(maps);

        int range = 100;
        List<MyTreeMap> myTreeMapList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            System.out.println("----------------" + (i + 1) + "--------------");
            myTreeMapList.add(getMyMap(range));
        }
        int a = percentBalanse();
        System.out.println("balans=" + balans +
                "\nnoBalans=" + noBalans +
                "\n" + percentBalanse() + "%");
    }

    private static int percentBalanse() {
        return (balans * 100 / (balans + noBalans));
    }

    private static MyTreeMap<Integer, Integer> getMyMap(int range) {
        MyTreeMap<Integer, Integer> mapInt = new MyTreeMap<>();
        while (Math.pow(2, 6) > mapInt.size() && mapInt.hight() != 6) {
            int r = -range + random.nextInt(range) * 2;
            mapInt.put(r, r);
        }
        countBalanse(mapInt);
        infoMap(mapInt);
        return mapInt;
    }

    private static void infoMap(MyTreeMap mapInt) {
        System.out.println("Size = " + mapInt.size() +
                " hight = " + mapInt.hight() +
                " balans =" + mapInt.isBalansed());
    }

    private static void countBalanse(MyTreeMap<Integer, Integer> mapInt) {
        if (mapInt.isBalansed()) balans++;
        else noBalans++;
    }
}
