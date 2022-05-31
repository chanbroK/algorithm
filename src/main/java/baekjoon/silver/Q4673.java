package baekjoon.silver;

import java.util.HashMap;
import java.util.HashSet;

public class Q4673 {
    // 셀프 넘버
    public static void main(String[] args) {
        HashSet<Integer> notSelfNums = new HashSet<>();
        int max_num = 10000;
        for (int i = 1; i <= max_num; i++) {
            notSelfNums.add(d(i));
        }
        for (int i = 1; i <= max_num; i++) {
            if (!notSelfNums.contains(i))
                System.out.println(i);
        }
    }

    public static int d(int n) {
        int result = n;

        while (n != 0) {
            result = result + n % 10;
            n = n / 10;
        }
        return result;
    }
}
