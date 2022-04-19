package kakao.intern2019;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//        s = "{{20,111},{111}}";
//        s = "{{123}}";
//        s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        // 앞뒤 {} 삭제
        s = s.substring(1, s.length() - 1);
        // },{ 에서 , 삭제
        s = s.replace("},{", "}{");
        System.out.println("processed string = " + s);
        // 문자열 순회하면서 집합으로 변환
        HashSet<HashSet<Integer>> totalSet = new HashSet<>();
        HashSet<Integer> partSet = null;
        Integer ele = 0;
        for (int i = 0; i < s.length(); i++) {
            String stringEle =
            if (c == '{') {
                // 집합 시작
                partSet = new HashSet<>();
            } else if (c == '}') {
                // 집합 끝
                partSet.add(ele);
                ele = 0;
                totalSet.add(partSet);
            } else if (c == ',') {
                // 다음 숫자
                partSet.add(ele);
                ele = 0;
            } else {
                // 숫자
                ele *= 10;
                ele += Integer.parseInt(c);
            }
        }
        System.out.println(totalSet);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
