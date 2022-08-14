package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/14
 **/
public class L70 {
    public static int climbStairs(int n) {
        if (n<3)
            return n;
        int pre1 =1,pre2=2;
        for(int i=3;i<=n;i++){
            int cur = pre2+pre1;
            pre1=pre2;
            pre2=cur;
        }
        return pre2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
