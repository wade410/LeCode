package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/27
 **/
public class L139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (String word : wordDict) {
                if (i > word.length() && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode",new ArrayList<>(Arrays.asList("leet","code"))));
    }

}
