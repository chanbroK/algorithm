package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[][] jobs) {
                // jobs sorting
                Arrays.sort(jobs, new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] <= o2[0]) {
                            return -1;
                        }
                        return 1;
                    }
                });
                // Add Comparator
                PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] < o2[1]) {
                            return -1;
                        }
                        return 1;
                    }
                });

                int time = 0;
                int index = 0;
                int answer = 0;

                while (true) {
                    while (index < jobs.length && jobs[index][0] <= time) {
                        queue.offer(jobs[index]);
                        index++;
                    }
                    if (queue.size() == 0) {
                        time = jobs[index][0];
                        continue;
                    }
                    int[] job = queue.poll();
                    time += job[1];
                    answer += time - job[0];
                    if (index == jobs.length && queue.size() == 0) {
                        break;
                    }
                }

                answer /= jobs.length;
                return answer;
            }
        }
    }
}
