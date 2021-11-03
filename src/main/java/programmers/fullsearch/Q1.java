package programmers.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] answers) {
                int[] student1Answer = {1, 2, 3, 4, 5};
                int[] student2Answer = {2, 1, 2, 3, 2, 4, 2, 5};
                int[] student3Answer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
                List<Integer> correctCounts = new ArrayList<>();
                correctCounts.add(0);
                correctCounts.add(0);
                correctCounts.add(0);

                for (int i = 0; i < answers.length; i++) {
                    int j = i % student1Answer.length;
                    int k = i % student2Answer.length;
                    int l = i % student3Answer.length;

                    if (answers[i] == student1Answer[j]) {
                        correctCounts.set(0, correctCounts.get(0) + 1);
                    }
                    if (answers[i] == student2Answer[k]) {
                        correctCounts.set(1, correctCounts.get(1) + 1);
                    }
                    if (answers[i] == student3Answer[l]) {
                        correctCounts.set(2, correctCounts.get(2) + 1);
                    }
                }

                List<Integer> mostCorrectors = new ArrayList<>();
                Integer max = Collections.max(correctCounts);
                for (int i = 0; i < correctCounts.size(); i++) {
                    if (correctCounts.get(i).equals(max)) {
                        mostCorrectors.add(i + 1);
                    }
                }

//                int[] result = new int[mostCorrectors.size()];
//                for (int i = 0; i < mostCorrectors.size(); i++) {
//                    result[i] = mostCorrectors.get(i) + 1;
//                }
                return mostCorrectors.stream().mapToInt(i -> i).toArray();
            }
        }
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(answers)));
    }
}
