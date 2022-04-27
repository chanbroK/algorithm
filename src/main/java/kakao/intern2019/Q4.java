package kakao.intern2019;

import java.util.*;

// 징검다리 건너기
public class Q4 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println("solution = " + solution(stones, k));
    }

    ///////////////////////////
//                  version 1
    ////////////////////////////
//    public static int solution(int[] stones, int k) {
//        int answer = 0;
//        ArrayList<Integer> stoneList = new ArrayList<>();
//        for (int val : stones) {
//            stoneList.add(val);
//        }
//        //최소 값 구하기
//        Integer min = Integer.MAX_VALUE;
//        for (Integer val : stoneList) {
//            if (val < min) {
//                min = val;
//            }
//        }
//        // 최소 값 만큼의 사람은 무조건 지나감
//        for (int i = 0; i < stoneList.size(); i++) {
//            stoneList.set(i, stoneList.get(i) - min);
//        }
//        answer += min;
//        System.out.println("min = " + min);
//        System.out.println("stoneList = " + stoneList);
//        int stopFlag = 0;
//        while (true) {
//            // 연속해서 0인 디딤돌의 수
//            int cnt = 0;
//            for (int i = 0; i < stoneList.size(); i++) {
//                Integer cur = stoneList.get(i);
//                if (cur > 0) {
//                    cnt = 0;
//                    stoneList.set(i, cur - 1);
//                } else if (cur.equals(0)) {
//                    cnt++;
//                }
//                if (cnt == k) {
//                    stopFlag = 1;
//                    break;
//                }
//            }
//            if (stopFlag != 0) {
//                break;
//            }
//            answer++;
//            System.out.println("stoneList = " + stoneList);
//        }
//        return answer;
    ///////////////////////////
//                  version 2
    ////////////////////////////
    public static int solution(int[] stones, int k) {
        int answer = 0;
        // 건널 수 있는 사람이라는 가상의 배열이 있다고 생각하고 이진탐색
        // Binary Search start, end value
        System.out.println("stones = " + Arrays.toString(stones));
        int start = 0;
        int end = Integer.MIN_VALUE;
        for (int stone : stones) {
            if (stone > end) {
                end = stone;
            }
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        while (start <= end) {
            int mid = (end + start) / 2;
            System.out.println("mid = " + mid);
            int cnt = 0;
            for (int stone : stones) {
                if (stone <= mid) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    break;
                }
            }
            if (cnt >= k) {
                // mid명 의 사람이 건너고 나서부터 다음 사람은 건널 수 없는 상황
                answer = mid;
                end = mid - 1;
            } else {
                // start명 보다 적은 사람은 건너는게 보장
                start = mid + 1;
            }
        }
        return answer;
    }
}
