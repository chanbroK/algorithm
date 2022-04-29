package kakao.intern2021;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        s = "23four5six7";
        s = "2three45sixseven";
        s = "123";

        System.out.println("solution = " + solution(s));
    }

    public static int solution(String s) {
        String[] stringNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < stringNums.length; i++) {
            s = s.replaceAll(stringNums[i], String.valueOf(i));
        }
        System.out.println("s = " + s);

        return Integer.parseInt(s);
    }
}
