package programmers.greedy;

public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int[] lost, int[] reserve) {
                int[] array = new int[n];
                int result = n;
                // 처음에 모두가 체육복을 가짐
                for (int i = 0; i < n; i++) {
                    array[i] = 1;
                }
                // lost 적용
                for (int v : lost) {
                    array[v - 1]--;
                }
                // reserve 적용
                for (int v : reserve) {
                    array[v - 1]++;
                }
                // 체육복 빌리기
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 0) {
                        // 앞 사람에게 빌리기
                        if (i - 1 >= 0 && array[i - 1] == 2) {
                            array[i]++;
                            array[i - 1]--;
                            // 뒤 사람에게 빌리기
                        } else if (i + 1 < array.length && array[i + 1] == 2) {
                            array[i]++;
                            array[i + 1]--;
                        } else {
                            result--;
                        }
                    }
                }
                return result;
            }
        }
        Solution solution = new Solution();

        //case 1
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution.solution(n, lost, reserve));
//        case2
//        n = 5;
//        lost = new int[]{2, 4};
//        reserve = new int[]{3};
//        System.out.println(solution.solution(n, lost, reserve));
//        case 3
//        n = 3;
//        lost = new int[]{3};
//        reserve = new int[]{1};
//        System.out.println(solution.solution(n, lost, reserve));
//        case 4
//        n = 5;
//        lost = new int[]{1, 2, 3, 4, 5};
//        reserve = new int[]{1};
//        System.out.println(solution.solution(n, lost, reserve));
        //case 5
        n = 5;
        lost = new int[]{3, 5};
        reserve = new int[]{2, 4};
        System.out.println(solution.solution(n, reserve, lost));

    }
}
