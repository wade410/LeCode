package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/16
 **/
public class L121 {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && prices[j] > prices[i]; j++) {
                int diff = prices[j] - prices[i];
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int maxProfitOpt(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max =0;
        int n =prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }else {
                max = Math.max(max,prices[i]-minPrice);
            }
        }
        return max;
    }

}
