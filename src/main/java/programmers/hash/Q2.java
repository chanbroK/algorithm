package programmers.hash;

import java.util.HashSet;

public class Q2 {
    class Solution {
        public boolean solution(String[] phone_book) {
            HashSet<String> hs = new HashSet<>();
            for (String x : phone_book) {
                hs.add(x);
            }
            for (String x : phone_book) {
                for (int i = 0; i < x.length(); i++) {
                    if (hs.contains(x.substring(0, i))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
