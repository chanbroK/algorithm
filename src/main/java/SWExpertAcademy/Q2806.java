package SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class Q2806 {
    // N-Queen
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] table = new int[n][n];
            int result = batchQueen(table, 0);
            System.out.println("#" + test_case + " " + result);
        }
    }

    public static int[][] fillTable(int[][] table, int row, int col) {
        int[][] newTable = new int[table.length][table.length];
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, table.length);
        }
        // 행 채우기
        for (int i = 0; i < newTable.length; i++) {
            // 행 채우기
            newTable[row][i] = 1;
            // 열 채우기
            newTable[i][col] = 1;
            // 오른쪽 위 대각선
            if (row - i >= 0 && col + i < newTable.length) {
                newTable[row - i][col + i] = 1;
            }
            // 오른쪽 아래 대각선
            if (row + i < newTable.length && col + i < newTable.length) {
                newTable[row + i][col + i] = 1;
            }
            // 왼쪽 위 대각선
            if (row - i >= 0 && col - i >= 0) {
                newTable[row - i][col - i] = 1;
            }
            // 왼쪽 아래 대각선
            if (row + i < newTable.length && col - i >= 0) {
                newTable[row + i][col - i] = 1;
            }
        }
        return newTable;
    }

    public static int batchQueen(int[][] table, int curCol) {
        int result = 0;
        if (curCol == table.length) {
            return 1;
        }
        for (int row = 0; row < table.length; row++) {
            if (table[row][curCol] == 0) {
                // table 복사하고 행, 열 ,대각선 1로 채움
                int[][] newTable = fillTable(table, row, curCol);
                result += batchQueen(newTable, curCol + 1);
            }
        }
        return result;
    }
}
