package kakao.intern2022;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] scores = new int[8];
        int idx = 0;
        for (String ele : survey) {
            if (ele.equals("RT")) {
                if (choices[idx] < 4)
                    scores[0] += 4 - choices[idx];
                else
                    scores[1] += choices[idx] - 4;
            } else if (ele.equals("TR")) {
                if (choices[idx] < 4)
                    scores[1] += 4 - choices[idx];
                else
                    scores[0] += choices[idx] - 4;
            } else if (ele.equals("FC")) {
                if (choices[idx] < 4)
                    scores[3] += 4 - choices[idx];
                else
                    scores[2] += choices[idx] - 4;
            } else if (ele.equals("CF")) {
                if (choices[idx] < 4)
                    scores[2] += 4 - choices[idx];
                else
                    scores[3] += choices[idx] - 4;
            } else if (ele.equals("MJ")) {
                if (choices[idx] < 4)
                    scores[5] += 4 - choices[idx];
                else
                    scores[4] += choices[idx] - 4;
            } else if (ele.equals("JM")) {
                if (choices[idx] < 4)
                    scores[4] += 4 - choices[idx];
                else
                    scores[5] += choices[idx] - 4;
            } else if (ele.equals("AN")) {
                if (choices[idx] < 4)
                    scores[6] += 4 - choices[idx];
                else
                    scores[7] += choices[idx] - 4;
            } else if (ele.equals("NA")) {
                if (choices[idx] < 4)
                    scores[7] += 4 - choices[idx];
                else
                    scores[6] += choices[idx] - 4;
            }
            idx++;
            System.out.println(Arrays.toString(scores));
        }

        if (scores[0] >= scores[1]) {
            answer += "R";
        } else {
            answer += "T";
        }
        if (scores[2] >= scores[3]) {
            answer += "C";
        } else {
            answer += "F";
        }
        if (scores[4] >= scores[5]) {
            answer += "J";
        } else {
            answer += "M";
        }
        if (scores[6] >= scores[7]) {
            answer += "A";
        } else {
            answer += "N";
        }


        return answer;
    }
}