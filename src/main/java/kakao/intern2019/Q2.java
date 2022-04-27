package kakao.intern2019;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 튜플

public class Q2 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        s = "{{20,111},{111}}";
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
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        ArrayList<Integer> partList = null;
        int ele = 0;
        for (int i = 0; i < s.length(); i++) {
            String stringEle = s.substring(i, i + 1);
            if (stringEle.equals("{")) {
                // 집합 시작
                partList = new ArrayList<>();
            } else if (stringEle.equals("}")) {
                // 집합 끝
                partList.add(ele);
                ele = 0;
                totalList.add(partList);
            } else if (stringEle.equals(",")) {
                // 다음 숫자
                partList.add(ele);
                ele = 0;
            } else {
                // 숫자
                ele *= 10;
                ele += Integer.parseInt(stringEle);
            }
        }
        System.out.println("totalSet = " + totalList);
        // 집합을 크기 순서대로 정렬
        totalList.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return Integer.compare(a.size(), b.size());
            }
        });
        System.out.println("Sorted totalSet = " + totalList);
        for (ArrayList<Integer> set : totalList) {
            set.removeAll(result);
            result.addAll(set);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
