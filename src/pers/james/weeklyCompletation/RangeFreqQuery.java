package pers.james.weeklyCompletation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 待完成
 */
public class RangeFreqQuery {
    private int[] arr;
    private Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        map = new HashMap<>(arr.length);
        calculateFrequency();
    }

    public int query(int left, int right, int value) {
        int ans = 0;
        List<Integer> list = this.map.get(value);
        if (list == null) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer index = list.get(i);
            if (index >= left && index <= right) {
                ans++;
            }
        }
        return ans;
    }

    private void calculateFrequency() {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (map.containsKey(value)) {
                List<Integer> integers = map.get(value);
                integers.add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(value, list);
            }
        }
    }


    /**
     * 超时
     * @param left
     * @param right
     * @param value
     * @return
     */
    public int query1(int left, int right, int value) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == value) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        rangeFreqQuery.query(1, 2, 4);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */


