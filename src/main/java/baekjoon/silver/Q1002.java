package baekjoon.silver;


import java.util.Scanner;

public class Q1002 {
    // 터렛
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            int point = 0;
            // 두 구심점 사이의 거리
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (distance == 0) {
                if (r1 == r2) {
                    // 두 원이 일치
                    point = -1;
                }

            } else {
                // 두 점에서 만난다.
                if (Math.abs(r1 - r2) < distance && distance < r1 + r2) {
                    point = 2;
                }
                // 한 점에서 만난다.(외접, 내접)
                else if (r1 + r2 == distance || Math.abs(r1 - r2) == distance) {
                    point = 1;
                }
                // 만나지 않는다.
                else {
                    point = 0;
                }
            }
            System.out.println(point);
        }
    }
}
