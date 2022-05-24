package SWExpertAcademy;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1206 {
    // View
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int length = sc.nextInt();
            int result = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                int input = sc.nextInt();
                queue.add(input);
                if (i >= 4) {
                    int max = Math.max(queue.get(0), Math.max(queue.get(1), Math.max(queue.get(3), queue.get(4))));
                    if (max < queue.get(2))
                        result += queue.get(2) - max;
                    queue.remove();
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
