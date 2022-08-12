package leetcode.top100;

import java.util.*;

/**
 * @Author HuShengHengao
 * @Date 2022/8/11
 **/
public class L49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0 || strs==null){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, ArrayList<Object>> map = new HashMap<>();
        for (String str : strs){
            int[] count = new int[26];
            Arrays.fill(count,0);
            for (Character c:str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <26 ; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String sb = stringBuilder.toString();
            if (!map.containsKey(sb)){
                map.put(sb,new ArrayList<>());
            }
            map.get(sb).add(str);
        }
        return new ArrayList(map.values());

    }


    public static void main(String[] args) {
        String[] strings = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strings));

    }
}
