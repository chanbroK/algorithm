package programmers.Sort;

import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {
        class Solution {
            public String solution(int[] numbers) {
                ArrayList<String> stringNumbers = new ArrayList<>();

                for (Integer number : numbers)
                    stringNumbers.add(number.toString());

                stringNumbers.sort((o1, o2) -> {
                    Integer x1 = Integer.parseInt(o1 + o2);
                    Integer x2 = Integer.parseInt(o2 + o1);
                    if (x1 > x2) {
                        return -1;
                    } else if (x1.equals(x2)) {
                        return 0;
                    } else {
                        return 1;
                    }
                });

                if (stringNumbers.get(0).equals("0")) {
                    // 모든 입력이 0 일때
                    return "0";
                } else {
                    String result = "";
                    for (String stringNumber : stringNumbers) {
                        result += stringNumber;
                    }
                    return result;
                }
            }
        }
        //        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {3, 30, 134, 5, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] numbers = {1, 10, 1000};
//        int[] numbers = {0, 0, 0, 0};
        int[] numbers = {979, 97, 978, 81, 818, 817};
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}