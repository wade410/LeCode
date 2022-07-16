package leetcode.top100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author HuWei05
 * @Date 2022/7/16
 **/
public class MovingAverage {
    Queue<Integer> queue;
    int size;
    int num;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size()>size){
            num-=queue.poll();
        }
        num+=val;
        queue.add(val);
        return num/queue.size();

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
    }
}
