package kakao.intern2019;

import java.util.*;

// 징검다리 건너기
public class Q4 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println("solution = " + solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
        while (true) {
            int flag = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > 0) {
                    flag = 0;
                    stones[i]--;
                } else if (stones[i] == 0) {
                    flag++;
                    
                }
            }
            if (flag == k) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
