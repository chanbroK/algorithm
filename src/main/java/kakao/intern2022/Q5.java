package kakao.intern2022;

import java.util.Arrays;

public class Q5 {

    public static void main(String[] args) {
//        int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        String[] operations = {"Rotate", "ShiftRow"};
//        int[][] rc = {{8, 6, 3}, {3, 3, 7}, {8, 4, 9}};
//        String[] operations = {"Rotate", "ShiftRow", "ShiftRow"};
        int[][] rc = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        String[] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};

        System.out.println("solution() = " + Arrays.deepToString(solution(rc, operations)));
    }

    public static int[][] solution(int[][] rc, String[] operations) {
        int w = rc[0].length;
        int h = rc.length;
        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                int temp = rc[0][0];
                // 가장 왼쪽
                for (int i = 1; i < h; i++) {
                    rc[i - 1][0] = rc[i][0];
                }
                // 가장 아래
                for (int i = 1; i < w; i++) {
                    rc[h - 1][i - 1] = rc[h - 1][i];
                }
                // 가장 오른쪽
                for (int i = h - 1; i > 0; i--) {
                    rc[i][w - 1] = rc[i - 1][w - 1];
                }
                // 가장 위
                for (int i = w - 2; i > 0; i--) {
                    rc[0][i + 1] = rc[0][i];
                }
                rc[0][1] = temp;
            } else {
                int[] temp = rc[rc.length - 1];
                for (int i = rc.length - 1; i > 0; i--) {
                    rc[i] = rc[i - 1];
                }
                rc[0] = temp;
            }
        }
        return rc;
    }
}