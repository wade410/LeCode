package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/21
 **/
public class L5 {
    public static String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen && isPalindrome(s, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i<j){
            if (s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindromeOpt(String s) {
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int oderNum = getLengthPalindrome(s,i,i);
            int evenNum = getLengthPalindrome(s,i,i+1);
            if (maxLen<Math.max(oderNum,evenNum)){
                maxLen = Math.max(oderNum,evenNum);
                begin=i-(maxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private static int getLengthPalindrome(String s, int i, int j) {
        while (j < s.length() && i >= 0 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeOpt("babad"));
        System.out.println("babad".substring(0,4));
    }
}
