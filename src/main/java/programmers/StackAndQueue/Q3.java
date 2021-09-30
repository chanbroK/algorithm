package programmers.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int bridge_length, int weight, int[] truck_weights) {
                int time = 1;
                int currentWeight = 0;
                List<Integer> arriveTrucks = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for (int i = 0; i < bridge_length; i++) {
                    queue.add(0);
                }
                int idx = 0;
                while (true) {
                    int end = queue.poll();
                    if (end != 0) {
                        currentWeight -= end;
                        arriveTrucks.add(end);
                    }
                    if (idx == truck_weights.length) {
                        break;
                    }
                    if (currentWeight + truck_weights[idx] <= weight) {
                        queue.add(truck_weights[idx]);
                        currentWeight += truck_weights[idx];
                        idx++;
                    } else {
                        queue.add(0);
                    }
                    time++;
                }
                while (!queue.isEmpty()) {
                    time++;
                    System.out.println("size = " + arriveTrucks.size());
                    int end = queue.poll();
                    if (end != 0) {
                        arriveTrucks.add(end);
                    }
                    if (arriveTrucks.size() == truck_weights.length) {
                        break;
                    }
                }
                return time;
            }
        }
//        int bridgeLength = 2;
//        int weight = 10;
//        int[] truck_weights = {7, 4, 5, 6};
        int bridgeLength = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        Solution solution = new Solution();
        System.out.println(solution.solution(bridgeLength, weight, truck_weights));
    }
}
