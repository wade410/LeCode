package leetcode.top100;

import java.util.Stack;

/**
 * @Author HuWei05
 * @Date 2022/7/13
 **/
public class L735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i:asteroids ) {
            if (stack.isEmpty()){
                stack.push(i);
            }else {
                if (stack.peek()*i>0){
                    stack.push(i);
                }else {
                    while (stack.isEmpty()) {
                        if (Math.abs(stack.peek()) > Math.abs(i)) {
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                    if (stack.isEmpty()) {
                        stack.push(i);
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        int cnt=0;
        while (stack.isEmpty()){
            res[cnt++]=stack.pop();
        }
        return res;
    }

}
