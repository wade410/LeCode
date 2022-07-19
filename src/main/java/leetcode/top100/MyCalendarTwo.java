package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuWei05
 * @Date 2022/7/19
 **/
public class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr :overlaps ) {
            if (arr[0]<start && arr[1]<end){
                return false;
            }
        }
        for (int[] arr:booked ) {
            if (arr[0]<start && arr[1]<end){
                overlaps.add(new int[]{Math.max(arr[0],start),Math.min(end,arr[1])});
            }
        }
        booked.add(new int[]{start,end});
        return true;

    }
}
