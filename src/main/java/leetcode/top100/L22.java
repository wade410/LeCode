package leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author HuWei05
 * @Date 2022/7/27
 **/
public class L22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n==0){
            return res;
        }
        String str = "()";
        backTrack(res,0,n*2,new StringBuffer(),str);
        return res;
    }

    private static void backTrack(List<String> res, int i, int n, StringBuffer stringBuffer, String str) {
        if (i==n){
            if (isVailable(stringBuffer)){
                res.add(stringBuffer.toString());
            }
        }else {
            for (int j = 0; j < str.length(); j++) {
                stringBuffer.append(str.charAt(j));
                backTrack(res,i+1,n,stringBuffer,str);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }

    }

    private static boolean isVailable(StringBuffer s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if (s.charAt(i)==')'){
                if (s.charAt(i)==')'&&stack.peek()=='(' ){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    public static List<String> generateParenthesisOpt(int n){
        List<String> list=new ArrayList<>();
        if(n==0)
            return list;
        dsf(list,n,n,"");
        return list;
    }
    private static void dsf(List<String> list, int left, int right, String cur) {
        if (left==0&&right==0){
            list.add(cur);
            return;
        }
        if (left>right)
            return;
        if (left>0){
            dsf(list,left-1,right,cur+"(");
        }
        if (right>0){
            dsf(list,left,right-1,cur+")");
        }

    }
/*
    dsf 使用深度优先，但是这里、使用了剪枝操作，这个剪枝呢正好规避了一些非有效括号，比较值得借鉴。
    最好用的还是回溯，但是回溯的前提是，每一个加入list的str都需要判断是不是有效括号。这里dsf比较有优势，通过right》left就规避掉这个问题
 */
    public static void main(String[] args) {
        System.out.println(generateParenthesisOpt(3));
    }
}
