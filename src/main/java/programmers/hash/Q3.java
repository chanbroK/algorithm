package programmers.hash;

import java.util.HashMap;

public class Q3 {
    class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> hm = new HashMap<>();

            for (String[] x : clothes) {
                hm.put(x[1], hm.getOrDefault(x[1], 1) + 1);
            }

            int sum = 1;
            for (String key : hm.keySet()) {
                sum = sum * hm.get(key);
            }

            return sum - 1;
        }
    }
}
