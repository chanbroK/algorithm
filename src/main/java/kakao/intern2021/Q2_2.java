package kakao.intern2021;

import java.util.Arrays;

public class Q2_2 {
    public static void main(String[] args) {
//        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//        String[][] places = {{"PXXXX", "XPXXX", "XXXPP", "XXXXX", "XXXXX"}};
        String[][] places = {{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}};
        System.out.println(Arrays.toString(new Solution().solution(places)));
    }

    static class Solution {

        boolean isPossible(int row, int col) {
            return row >= 0 && row < 5 && col >= 0 && col < 5;
        }

        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            // 좌우상하
            int[] rowMove = {1, -1, 0, 0}, colMove = {0, 0, 1, -1};

            for (int a = 0; a < places.length; a++) {
                int check = 1;
                // 자료 구조 변경
                System.out.println(Arrays.toString(places[a]));
                String[][] room = new String[5][5];
                for (int i = 0; i < places[a].length; i++) {
                    room[i] = places[a][i].split("");
                }
                System.out.println(Arrays.deepToString(room));
                // 한 자리 씩 순회
                loop:
                for (int row = 0; row < room.length; row++) {
                    for (int col = 0; col < room[row].length; col++) {
                        // O 상하좌우에 P가 두개 이상 있으면 안된다.
                        if (room[row][col].equals("O")) {
                            int cnt = 0;
                            for (int x = 0; x < 4; x++) {
                                int nextRow = row + rowMove[x];
                                int nextCol = col + colMove[x];
                                if (isPossible(nextRow, nextCol) && room[nextRow][nextCol].equals("P"))
                                    cnt++;
                            }
                            if (cnt >= 2) {
                                check = 0;
                                break loop;
                            }
                            // P 상하좌우에 P가 하나라도 있으면 안된다.
                        } else if (room[row][col].equals("P")) {
                            for (int x = 0; x < 4; x++) {
                                int nextRow = row + rowMove[x];
                                int nextCol = col + colMove[x];
                                if (isPossible(nextRow, nextCol) && room[nextRow][nextCol].equals("P")) {
                                    check = 0;
                                    break loop;
                                }

                            }
                        }
                    }
                }
                // 검사 결과 저장
                answer[a] = check;
            }
            return answer;
        }
    }
}
