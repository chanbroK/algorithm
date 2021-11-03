package programmers.heap;

import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] scoville, int K) {
                int answer = 0;
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                for (int item : scoville) {
                    heap.add(item);
                }
                while (heap.peek() < K) {
                    answer++;
                    Integer first = heap.poll();
                    Integer second = heap.poll();
                    if (first == null || second == null) {
                        return -1;
                    }
                    int score = first + second * 2;
                    heap.add(score);
                }
                return answer;
            }
        }
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        Solution solution = new Solution();
        System.out.println(solution.solution(scoville, K));
    }
}
