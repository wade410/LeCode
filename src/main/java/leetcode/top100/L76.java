package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/15
 **/
public class L76 {
    public String minWindow(String s, String t) {
        int[] need =new int[128];
        for (char c:t.toCharArray())
            need[c]++;
        int l=0,r=0;
        int start =0;
        int count=t.length();
        int size = Integer.MAX_VALUE;
        while (r<=s.length()-1){
            if (need[s.charAt(r)]>0)
                count--;
            need[s.charAt(r)]--;
            if (count ==0){
                while (l<r&&need[s.charAt(l)]<0){
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r-l+1<size){
                    size=r-l+1;
                    start=l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
