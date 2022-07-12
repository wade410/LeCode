package leetcode.top100;

import java.util.HashMap;

/**
 * @Author HuWei05
 * @Date 2022/7/12
 **/
public class L873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int maxLen =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a = arr[i];
                int b = arr[j];
                int len =2;
                for(int k=j+1;k<n;k++){
                    int c = arr[k];
                    if(c==a+b){
                        a=b;
                        b=c;
                        maxLen=Math.max(maxLen,++len);

                    }else if(a+b<c){//这里出问题了
                        break;
                    }
                }

            }
        }
        return maxLen;



    }

}
