package leetcode.top100;

import java.util.Stack;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/9
 **/
public class L856 {
    public static int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int len = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            len += s.charAt(i) == '(' ? 1 : -1;
            if (len == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len , n));
        }
    }

    public static void main(String[] args) {
        System.out.println("1234".substring(1,4));
        System.out.println(scoreOfParentheses("(()(()))"));
    }



}
