package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] array, int[][] commands) {
                int[] result = new int[commands.length];
                for (int i = 0; i < commands.length; i++) {
                    int start = commands[i][0] - 1;
                    int end = commands[i][1] - 1;
                    int index = commands[i][2] - 1;
                    List<Integer> arrList = new ArrayList<>();
                    for (int val : array)
                        arrList.add(val);
                    List<Integer> subArrList = arrList.subList(start, end + 1);
                    subArrList.sort((o1, o2) -> {
                        if (o1 > o2) {
                            return 1;
                        } else if (o1.equals(o2)) {
                            return 0;
                        } else {
                            return -1;
                        }
                    });
                    result[i] = subArrList.get(index);
                }
                return result;
            }
        }
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }
}
