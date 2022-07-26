package leetcode.top100;

import java.util.Stack;

/**
 * @Author HuWei05
 * @Date 2022/7/27
 **/
public class L20 {
    public static boolean isValid(String s) {
        if (s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if (s.charAt(i)=='}'||s.charAt(i)==']'||s.charAt(i)==')'){
                if (s.charAt(i)=='}'&&stack.peek()=='{'||s.charAt(i)==']'&&stack.peek()=='['||s.charAt(i)==')'&&stack.peek()=='(' ){
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

    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }
}
