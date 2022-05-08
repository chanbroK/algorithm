package kakao.intern2022;

import java.util.ArrayList;
import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
//        int alp = 10;
//        int cop = 10;
//        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};

        int alp = 0;
        int cop = 0;
        int[][] problems = {{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}};
//        
        System.out.println("solution(alp, cop, problems) = " + solution(alp, cop, problems));
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        // 아직 못푼 문제
        ArrayList<int[]> notSolved = new ArrayList<>(Arrays.asList(problems));
        // 이미 푼 문제(공부하기도 포함)
        ArrayList<int[]> solved = new ArrayList<>();
        solved.add(new int[]{0, 0, 1, 0, 1});
        solved.add(new int[]{0, 0, 0, 1, 1});

        while (!notSolved.isEmpty()) {
            // 가장 차이가 적은 문제 탐색
            int totalMinDif = Integer.MAX_VALUE;
            int[] problem = null;
            for (int[] e : notSolved) {
                int alpDif = (e[0] - alp);
                int copDif = (e[1] - cop);
                int totalDif = 0;
                if (alpDif > 0) {
                    totalDif += alpDif;
                }
                if (copDif > 0) {
                    totalDif += copDif;
                }

                if (totalDif < totalMinDif) {
                    problem = e;
                    totalMinDif = totalDif;
                }
            }
            if (totalMinDif > 0) {
                // 능력 채우기

                // 제일 최적의 시간 사용, 시간 대비 dif를 최대한 많이 줄여주는 방법
                float minTime = Float.MAX_VALUE;
                int alpDif = problem[0] - alp;
                int copDif = problem[1] - cop;
                int[] study = null;
                for (int[] e : solved) {
                    float alpTime = 0;
                    float copTime = 0;
                    if (e[2] != 0) {
                        alpTime = alpDif / (float) e[2];
                    } else {
                        alpTime = alpDif;
                    }
                    if (e[3] != 0) {
                        copTime = copDif / (float) e[3];
                    } else {
                        copTime = copDif;
                    }
                    if ((Math.max(alpTime, copTime)) <= minTime) {
                        minTime = Math.max(alpTime, copTime);
                        study = e;
                    }
                }
                // 학습
                alp += study[2];
                cop += study[3];
                answer += study[4];
                System.out.println("alp = " + alp + "cop = " + cop + "study = " + Arrays.toString(study));
            } else {
                // 문제 풀기
                notSolved.remove(problem);
//                alp += problem[2];
//                cop += problem[3];
//                answer += problem[4];
                solved.add(problem);
            }
        }
        return answer;
    }
}
