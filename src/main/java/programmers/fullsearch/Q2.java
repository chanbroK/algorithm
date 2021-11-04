package programmers.fullsearch;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        class Solution {
            public Set<Integer> recursive(String combination, String others, Set<Integer> combinationSet) {
                System.out.println(combination);
                if (!combination.equals("")) {
                    combinationSet.add(Integer.parseInt(combination));
                }
                for (int i = 0; i < others.length(); i++) {
                    recursive(combination + others.charAt(i), others.substring(0, i) + others.substring(i + 1), combinationSet);
                }
                return combinationSet;
            }

            public int solution(String numbers) {
                int answer = 0;
                Set<Integer> combinationSet = new HashSet<>();
                recursive("", numbers, combinationSet);
                System.out.println(combinationSet);

                for (Integer combination : combinationSet) {
                    boolean isPrime = true;
                    for (int i = 2; i < combination; i++) {
                        if (combination % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime && combination != 0 && combination != 1)
                        answer++;
                }
                return answer;
            }
        }
//        String numbers = "17";
        String numbers = "011";
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}
