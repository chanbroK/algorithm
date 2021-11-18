package programmers.greedy;

public class Q2 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String name) {
                int result = 0;
                // 좌,우 이동 최소 다음 위치
                int minMove = name.length() - 1;

                for (int i = 0; i < name.length(); i++) {
                    // 상,하 이동
                    char c = name.charAt(i);
                    int moveUp = 'Z' - c + 1;
                    int moveDown = c - 'A';
                    // 이동 적용
                    result += Math.min(moveUp, moveDown);

                    //좌,우 이동
                    // 다음 단어가 A이고, name이 끝나기 전까지 다음 위치 idx 증가
                    int next = i + 1;
                    while (next < name.length() && name.charAt(next) == 'A') {
                        next++;
                    }
                    minMove = Math.min(minMove, (i * 2) + name.length() - next);
                }
                result += minMove;
                return result;
            }
        }
        Solution solution = new Solution();
        String name = "JEROEN";
//        String name = "BBBBAABBB";
//        String name = "JAZ";
        System.out.println(solution.solution(name));
    }
}
