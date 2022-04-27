package kakao.intern2019;

import java.util.*;


// 불량 사용자
public class Q3 {
    public static void main(String[] args) {
//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"*rodo", "*rodo", "******"};
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        // banned_id 마다 가능한 후보 아이디 리스트를 생성
        ArrayList<ArrayList<String>> totalCandList = new ArrayList<>();

        // 문자 하나씩 비교하면서 패턴 일치 확인
        for (String bi : banned_id) {
            ArrayList<String> partCandList = new ArrayList<>();
            for (String ui : user_id) {
                int flag = 0;
                if (ui.length() != bi.length()) {
                    // 길이가 다르므로 불일치
                    continue;
                }
                for (int i = 0; i < ui.length(); i++) {
                    if (ui.charAt(i) != bi.charAt(i) && bi.charAt(i) != '*') {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    partCandList.add(ui);
                }
            }
            totalCandList.add(partCandList);
        }
        HashSet<HashSet<String>> result = new HashSet<>();
        // 만들어진 후보 리스트에서 한 id 씩 뽑아서 제재아이디 조합 생성 (DFS)
        dfs(result, totalCandList, 0, new HashSet<>());
        return result.size();
    }

    public static void dfs(HashSet<HashSet<String>> result, ArrayList<ArrayList<String>> totalCandList, int col, HashSet<String> temp) {
        if (col == totalCandList.size()) {
            result.add(temp);
            return;
        }
        ArrayList<String> curCandList = totalCandList.get(col);
        for (String curCand : curCandList) {
            if (!temp.contains(curCand)) {
                HashSet<String> newTemp = new HashSet<>(temp);
                newTemp.add(curCand);
                dfs(result, totalCandList, col + 1, newTemp);
            }
        }
    }
}
