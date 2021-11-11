package programmers.greedy;

import java.util.ArrayList;

//contains 사용?
public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int[] lost, int[] reserve) {
                ArrayList<Integer> possible = new ArrayList<>();
                ArrayList<Integer> lostList = new ArrayList<>();
                for (int x : lost)
                    lostList.add(x);
                ArrayList<Integer> reserveList = new ArrayList<>();
                for (int x : reserve)
                    reserveList.add(x);
                for (int i = 0; i < n; i++) {
                    int count = 1;
                    if (lostList.contains(i + 1))
                        count--;
                    if (reserveList.contains(i + 1))
                        count++;
                    possible.add(count);
                }
                // 뒤 번호에게 빌리기
                for (int i = 0; i < possible.size() - 1; i++) {
                    if (possible.get(i) == 0 && possible.get(i + 1) == 2) {
                        possible.set(i, 1);
                        possible.set(i + 1, 1);
                    }
                }
                // 앞 번호에게 빌리기
                for (int i = 1; i < possible.size(); i++) {
                    if (possible.get(i) == 0 && possible.get(i - 1) == 2) {
                        possible.set(i, 1);
                        possible.set(i - 1, 1);
                    }
                }
                int count = 0;
                for (int val : possible) {
                    if (val != 0)
                        count++;
                }
                return count;
            }
        }
        Solution solution = new Solution();

        //case 1
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution.solution(n, lost, reserve));
        //case2
        n = 5;
        lost = new int[]{2, 4};
        reserve = new int[]{3};
        System.out.println(solution.solution(n, lost, reserve));
        //case 3
        n = 3;
        lost = new int[]{3};
        reserve = new int[]{1};
        System.out.println(solution.solution(n, lost, reserve));
        //case 4
        n = 5;
        lost = new int[]{1, 2, 3, 4, 5};
        reserve = new int[]{1};
        System.out.println(solution.solution(n, lost, reserve));
        //case 5
        n = 5;
        lost = new int[]{3, 5};
        reserve = new int[]{2, 4};
        System.out.println(solution.solution(n, lost, reserve));

    }
}
