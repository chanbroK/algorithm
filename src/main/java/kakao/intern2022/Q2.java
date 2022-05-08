package kakao.intern2022;

import java.sql.Array;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int sum1, sum2;
        sum1 = Arrays.stream(queue1).sum();
        sum2 = Arrays.stream(queue2).sum();
        // 합이 홀수면 동일하게 나눌 수 없음
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        // 같아지는 지점
        int target = (sum1 + sum2) / 2;
        // 큐 자료구조로 변환
        LinkedList<Integer> q1 = new LinkedList<>();
        for (int v : queue1) {
            if (v > target) {
                // 같아 지는 지점보다 값이 큰 원소가 있으면 불가능
                return -1;
            }
            q1.add(v);
        }
        LinkedList<Integer> q2 = new LinkedList<>();
        for (int v : queue2) {
            if (v > target) {
                return -1;
            }
            q2.add(v);
        }
        // 이전에 시도했던 큐들의 집합
        Set<LinkedList<Integer>> beforeQueue = new HashSet<>();
        while (target != sum1) {
            if (beforeQueue.contains(q1)) {
                // 이미 시도 했던 큐가 반복하는 것은 원소의 합을 같게 만들 수 없다는 뜻
                return -1;
            } else {
                beforeQueue.add(q1);
            }
            // 절대값을 통해 어느 큐에 연산 결정권을 줄 지 결
            int dif1 = target - sum1;
            int dif2 = target - sum2;
            answer++;
            if (Math.abs(dif1) > Math.abs(dif2)) {
                if (dif1 > 0) {
                    Integer val = q2.poll();
                    q2.offer(val);
                    sum1 += val;
                    sum2 -= val;
                } else {
                    Integer val = q1.poll();
                    q2.offer(val);
                    sum1 -= val;
                    sum2 += val;
                }
            } else if (Math.abs(dif1) < Math.abs(dif2)) {
                if (dif2 < 0) {
                    Integer val = q2.poll();
                    q1.offer(val);
                    sum1 += val;
                    sum2 -= val;
                } else {
                    Integer val = q1.poll();
                    q2.offer(val);
                    sum1 -= val;
                    sum2 += val;
                }
            } else {
                // 한 큐로 모든 원소가 이동했을때
                if (dif2 < 0) {
                    Integer val = q2.poll();
                    q1.offer(val);
                    sum1 += val;
                    sum2 -= val;
                } else {
                    Integer val = q1.poll();
                    q2.offer(val);
                    sum1 -= val;
                    sum2 += val;
                }
            }
        }
        return answer;
    }
}