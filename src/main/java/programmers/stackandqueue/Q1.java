package programmers.stackandqueue;

import java.util.Arrays;
import java.util.Stack;


public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] progresses, int[] speeds) {
                Stack<Integer> stack = new Stack<>();
                int[] answer = {};
                for (int i = progresses.length - 1; i >= 0; i--) {
                    stack.push(progresses[i]);
                }

                int day = 1;
                int idx = 0;
                int outCount = 0;
                while (true) {
                    if (stack.isEmpty()) {
                        answer = Arrays.copyOf(answer, answer.length + 1);
                        answer[answer.length - 1] = outCount;
                        break;
                    }
                    if ((stack.peek() + (day * speeds[idx])) >= 100) {
                        outCount++;
                        stack.pop();
                        idx++;
                    } else {
                        if (outCount != 0) {
                            answer = Arrays.copyOf(answer, answer.length + 1);
                            answer[answer.length - 1] = outCount;
                        }
                        outCount = 0;
                        day++;
                    }
                }
                return answer;
            }
        }
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {96, 94};
        int[] speeds = {3, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));
    }
}
