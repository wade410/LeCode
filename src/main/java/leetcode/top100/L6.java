package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/23
 **/
public class L6 {
    public static String convert(String s, int numRows) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = s.length();
        int cnt = (numRows - 1) * 2;
        int newCnt = cnt;
        int t =0;
        while (t*cnt<n){
            stringBuilder.append(s.charAt(t*cnt));
            t++;
        }



        for (int i = 1; i < numRows-1; i++) {
            stringBuilder.append(s.charAt(i));
           newCnt -= 2;
           int resCnt = cnt-newCnt;
           int k = i+newCnt;
           int j=1;
           while (k<n){
               stringBuilder.append(s.charAt(k));
               if (j++%2==1){
                   k+=resCnt;
               }else {
                   k+=newCnt;
               }
           }
        }
        int m = numRows-1;
        int z=0;
        while (m+z*cnt<n){
            stringBuilder.append(s.charAt(m+z*cnt));
            z++;
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
