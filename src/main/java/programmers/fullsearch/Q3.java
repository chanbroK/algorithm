package programmers.fullsearch;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int brown, int yellow) {
                int[] result = new int[2];
                for (int w = 3; w <= yellow + 2; w++) {
                    for (int h = 3; h <= yellow + 2; h++) {
                        if (h * w == brown + yellow && w >= h && (w * 2 + (h - 2) * 2) == brown) {
                            result[0] = w;
                            result[1] = h;
                            return result;
                        }
                    }
                }
                return result;
            }
        }
//        int brown = 10;
//        int yellow = 2;
//        int brown = 8;
//        int yellow = 1;
        int brown = 24;
        int yellow = 24;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(brown, yellow)));
    }
}
