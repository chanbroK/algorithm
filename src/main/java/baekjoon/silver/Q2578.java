package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2578 {
    // 빙고
    public static void main(String[] args) {
//         테이블 입력
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (String input : sc.nextLine().split(" ")) {
                row.add(Integer.parseInt(input));
            }
            table.add(row);
        }
//         사회자의 수 입력
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            numList.add(sc.nextInt());
        }
//        숫자 지우기
        int cnt = 0; // 빙고 개수
        for (Integer num : numList) {
            // 숫자 찾아서 지움
            int rowIdx = 0, colIdx = 0;
            for (ArrayList<Integer> row : table) {
                if (row.contains(num)) {
                    colIdx = row.indexOf(num);
                    rowIdx = table.indexOf(row);
                    row.set(row.indexOf(num), 0);
                }
            }
            // col check
            int check = 0;
            for (int i = 0; i < 5; i++) {
                if (table.get(i).get(colIdx) != 0) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) {
                // 빙고!!
                cnt++;
            }
            // row check
            check = 0;
            for (int i = 0; i < 5; i++) {
                if (table.get(rowIdx).get(i) != 0) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) {
                // 빙고!!
                cnt++;
            }
            // diagonal check
            if (colIdx + rowIdx == 4 || colIdx == rowIdx) {
                check = 0;
                if (colIdx + rowIdx == 4) {
                    for (int i = 0; i < 5; i++) {
                        if (table.get(i).get(4 - i) != 0) {
                            check = 1;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        if (table.get(i).get(i) != 0) {
                            check = 1;
                            break;
                        }
                    }
                }
                if (check == 0) {
                    // 빙고 !!
                    cnt++;
                }
            }

            if (cnt >= 3) {
                for (ArrayList<Integer> row : table) {
                    System.out.println(row);
                }
                System.out.println(numList.indexOf(num) + 1);
                break;
            }
        }

    }
}
