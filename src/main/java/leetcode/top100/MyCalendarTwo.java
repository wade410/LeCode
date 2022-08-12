package leetcode.top100;

import java.util.*;

/**
 * @Author HuShengHengao
 * @Date 2022/7/19
 **/
public class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;

//    public MyCalendarTwo() {
//        booked = new ArrayList<>();
//        overlaps = new ArrayList<>();
//    }
//
//    public boolean book(int start, int end) {
//        for (int[] arr :overlaps ) {
//            if (arr[0]<start && arr[1]<end){
//                return false;
//            }
//        }
//        for (int[] arr:booked ) {
//            if (arr[0]<start && arr[1]<end){
//                overlaps.add(new int[]{Math.max(arr[0],start),Math.min(end,arr[1])});
//            }
//        }
//        booked.add(new int[]{start,end});
//        return true;
//
//    }
TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int cnt=0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer>  entry:map.entrySet()){
            cnt+=entry.getValue();
            if (cnt>2){
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}
