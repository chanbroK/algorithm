package SWExpertAcademy;

import java.util.Scanner;

public class Q14178 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int d = sc.nextInt();
            int range = d * 2 + 1;
            int result;
            if (n % range != 0)
                result = n / range + 1;
            else
                result = n / range;
            System.out.println(result);

        }
    }
}
