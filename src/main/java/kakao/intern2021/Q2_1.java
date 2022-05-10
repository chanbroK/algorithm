package kakao.intern2021;

import java.util.Arrays;

public class Q2_1 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//        String[][] places = {{"PXXXX", "XPXXX", "XXXPP", "XXXXX", "XXXXX"}};
        System.out.println(Arrays.toString(new Solution().solution(places)));
    }

    static class Solution {
        public int checkPlace(String[][] place, int row, int col) {
            if (row - 1 >= 0 && place[row - 1][col].equals("P")) {
                // 상1
                return 0;
            }
            if (row + 1 < place.length && place[row + 1][col].equals("P")) {
                // 하1
                return 0;
            }
            if (col - 1 >= 0 && place[row][col - 1].equals("P")) {
                // 좌1
                return 0;
            }
            if (col + 1 < place.length && place[row][col + 1].equals("P")) {
                // 우1
                return 0;
            }

            // 맨해튼 거리 2에 사람이 앉으려면 그 사이는 빈테이블이면 안된다.
            if (row - 2 >= 0 && place[row - 2][col].equals("P") && !place[row - 1][col].equals("X")) {
                // 상2
                return 0;
            }
            if (row + 2 < place.length && place[row + 2][col].equals("P") && !place[row + 1][col].equals("X")) {
                // 하2
                return 0;
            }
            if (col - 2 >= 0 && place[row][col - 2].equals("P") && !place[row][col - 1].equals("X")) {
                // 좌2
                return 0;
            }
            if (col + 2 < place.length && place[row][col + 2].equals("P") && !place[row][col + 1].equals("X")) {
                // 우2
                return 0;
            }
            // 대각선
            if ((row - 1 >= 0 && col - 1 >= 0 && place[row - 1][col - 1].equals("P")) && !(place[row - 1][col].equals("X") && place[row][col - 1].equals("X"))) {
                // 좌상
                return 0;
            }
            if (row + 1 < place.length && col - 1 >= 0 && place[row + 1][col - 1].equals("P") && !(place[row + 1][col].equals("X") && place[row][col - 1].equals("X"))) {
                // 좌하
                return 0;
            }

            if (row - 1 >= 0 && col + 1 < place.length && place[row - 1][col + 1].equals("P") && !(place[row - 1][col].equals("X") && place[row][col + 1].equals("X"))) {
                // 우상
                return 0;
            }

            if (row + 1 < place.length && col + 1 < place.length && place[row + 1][col + 1].equals("P") && !(place[row + 1][col].equals("X") && place[row][col + 1].equals("X"))) {
                // 우하
                return 0;
            }
            return 1;
        }

        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            for (int a = 0; a < places.length; a++) {
                int check = 1;
                // 자료 구조 변경
                String[][] room = new String[5][5];
                for (int i = 0; i < places[a].length; i++) {
                    room[i] = places[a][i].split("");
                }
                // 한 자리 씩 순회
                loop:
                for (int i = 0; i < room.length; i++) {
                    for (int j = 0; j < room[i].length; j++) {
                        if (room[i][j].equals("P")) {
                            check = checkPlace(room, i, j);
                            if (check == 0)
                                break loop;
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
