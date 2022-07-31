package leetcode.top100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author HuWei05
 * @Date 2022/7/31
 **/
public class L33 {
    public static int longestValidParenthesesStack(String s) {
        int len = s.length();
        Stack<Integer> stack= new Stack();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen  = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParenthesesDouble(String s){
        int len  =s.length();
        int left=0;
        int right=0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if (left==right){
                maxLen = Math.max(maxLen,left+right);
            }
            if (right>left){
                left=0;
                right=0;
            }
        }
        left=right=0;
        for (int i = len-1; i >0 ; i--) {
            if (s.charAt(i)==')'){
                right++;
            }else {
                left++;
            }
            if (right==left){
                maxLen = Math.max(maxLen,left+right);
            }
            if (left>right){
                left=right=0;
            }

        }
        return maxLen;
    }
    public static int longestValidParenthesesDp(String s){
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthesesDouble("(()"));
    }

}
