package SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class Q2805 {
    // 농작물 수확하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int margin = 0;
            int result = 0;
            int mid = n / 2;
            for (int i = 0; i < n; i++) {
                String[] line = sc.next().split("");
                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(line[j]);
                    if (mid - margin <= j && mid + margin >= j)
                        result += val;
                }
                if (i >= mid)
                    margin--;
                else
                    margin++;
            }
            System.out.println("#" + test_case + " " + result);

        }

    }
}
