package less8;

import java.util.HashMap;
import java.util.Random;

public class Main8 {

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(Math.abs(x));
        long a = Long.MAX_VALUE;
        System.out.println(Long.toBinaryString(a));
        a = a >>> 32;
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toBinaryString(a));
        while (sb.length() != 63) sb.insert(0, 0);
        System.out.println(sb);
        sb.setLength(0);
        a = Long.MAX_VALUE;
        a = a ^ (a >>> 32);
        System.out.println(Long.toBinaryString(a));

        System.out.println(Integer.toBinaryString(x));
        System.out.println("0" + Integer.toBinaryString(0x7fffffff)); //f=1111;
        Random r = new Random();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            int y = r.nextInt()%8;
            int y = r.nextInt() % 7;
        }

        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(6));

        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>();
        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");
        chm.put(4, "four");
        chm.put(5, "five");
        System.out.println(chm.get(3));

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            chm.put(random.nextInt(100), "");
        }

        System.out.println(chm);
        chm.delete(3);
        System.out.println(chm);
        chm.put(3, "three");
        System.out.println(chm);
    }
}
