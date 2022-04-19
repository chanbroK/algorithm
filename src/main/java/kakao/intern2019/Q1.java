package kakao.intern2019;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int col : moves) {
            // 크레인의 위치 = board 의 col
            for (int[] row : board) {
                // board 의 row,col 을 통해 해당 col 에서 인형이 있는 곳까지 접근
                int value = row[col - 1];
                if (value != 0) {
                    System.out.println(value);
                    if (stack.isEmpty()) {
                        stack.push(value);
                    } else {
                        if (stack.peek() == value) {
                            // 같은 인형 삭제 -> push 후 2번 pop
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(value);
                        }
                    }
                    // 인형 빼고 나서는 0으로 바꾸어줌
                    row[col - 1] = 0;
                    // 처음 발견된 인형만 뺌
                    break;
                }
            }
        }
        return answer;
    }
}
