package programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q3 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String[] arguments) {
                int[] answer = {0, 0};
                //min heap
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                //max heap
                PriorityQueue<Integer> reversePq = new PriorityQueue<Integer>(Collections.reverseOrder());

                for (int i = 0; i < arguments.length; i++) {
                    String[] temp = arguments[i].split(" ");
                    switch (temp[0]) {
                        // insert
                        case "I":
                            pq.add(Integer.parseInt(temp[1]));
                            reversePq.add(Integer.parseInt(temp[1]));
                            break;
                        case "D":
                            if (pq.size() > 0) {
                                if (Integer.parseInt(temp[1]) == 1) {
                                    // remove max
                                    int max = reversePq.poll();
                                    pq.remove(max);
                                } else {
                                    // removie min
                                    int min = pq.poll();
                                    reversePq.remove(min);
                                }
                            }
                            break;
                    }
                }
                if (pq.size() >= 2) {
                    answer[0] = reversePq.poll();
                    answer[1] = pq.poll();
                }
                return answer;
            }
        }

    }
}
