package programmers.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] priorities, int location) {
                int answer = 0;
                Queue<Integer> queue = new LinkedList<>();
                for (int priority : priorities) {
                    queue.add(priority);
                }
                System.out.println(queue);
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    if (queue.stream().filter(integer -> integer > poll).count() == 0) {
                        answer++;
                        if (location == 0) {
                            break;
                        } else {
                            location--;
                        }
                    } else {
                        if (location == 0) {
                            location = queue.size();
                        } else {
                            location--;
                        }
                        queue.add(poll);
                    }
                }
                return answer;
            }
        }
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }
}
