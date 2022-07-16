package leetcode.top100;

import java.util.*;

/**
 * @Author HuWei05
 * @Date 2022/7/16
 **/
public class L3 {
    public int lengthOfLongestSubstringQueue(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int maxLen = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.add(s.charAt(i));
            maxLen = Math.max(maxLen, queue.size());
        }
        return maxLen;
    }
    public int lengthOfLongestSubstringSet(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> hashSet = new HashSet<>();
        int left =0;
        int maxLen =0;
        for (int i = 0; i < s.length(); i++) {
            while (hashSet.contains(s.charAt(i))){
                hashSet.remove(s.charAt(left++));
            }
            hashSet.add(s.charAt(i));
            maxLen = Math.max(maxLen,hashSet.size());
        }
        return maxLen;
    }
    public int lengthOfLongestSubstringHashMap(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int left =0 ;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)));
            }
            maxLen=Math.max(maxLen,i-left);
            map.put(s.charAt(i),i);
        }
        return maxLen;
    }
}
