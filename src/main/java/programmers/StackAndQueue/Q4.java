package programmers.StackAndQueue;

import java.util.Arrays;

public class Q4 {

    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] prices) {
                int[] answer = new int[prices.length];
                for (int i = 0; i < prices.length; i++) {
                    for (int j = i + 1; j < prices.length; j++) {
                        answer[i]++;
                        if (prices[i] > prices[j]) {
                            break;
                        }
                    }
                }
                return answer;
            }
        }
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 2, 3};
//        int[] prices = {1, 2, 3, 3, 2, 3};
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}
