package baekjoon.bronze;

import java.util.ArrayList;
import java.util.Scanner;

//
public class Q2309 {
    // 일곱난쟁이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            input.add(sc.nextInt());
        }
        input = selectNum(input, new ArrayList<>(), 0);
        input.sort((a, b) -> {
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            else
                return 0;
        });
        for (Integer val : input) {
            System.out.println(val);
        }
    }

    public static ArrayList<Integer> selectNum(ArrayList<Integer> choices, ArrayList<Integer> selected, int sum) {
        if (sum > 100) {
            return null;
        }
        if (selected.size() == 7) {
            if (sum == 100) {
                return selected;
            } else {
                return null;
            }
        }
        ArrayList<Integer> result = null;
        for (int i = 0; i < choices.size(); i++) {
            if (!selected.contains(choices.get(i))) {
                ArrayList<Integer> nextSelected = new ArrayList<>(selected);
                nextSelected.add(choices.get(i));
                ArrayList<Integer> temp = selectNum(choices, nextSelected, sum + choices.get(i));
                if (temp != null) {
                    result = temp;
                }
            }
        }
        return result;
    }
}
