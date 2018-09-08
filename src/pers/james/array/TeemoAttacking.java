package pers.james.array;

import java.util.Arrays;

public class TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries = {3,3};
        System.out.println(findPoisonedDuration(timeSeries, 2));
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length, ans = 0;
        Arrays.sort(timeSeries);
        int endPoint = timeSeries[0]+duration-1;
        for (int i = 1; i < timeSeries.length; i++){
            int startPoint = timeSeries[i];
            if (startPoint > endPoint){
                ans += duration;
                if (i == len - 1){
                    ans += duration;
                }
//                endPoint = startPoint + duration - 1;
            }else if (startPoint < endPoint){
                if (startPoint+duration-1 <= endPoint){
                    ans += duration;
                    endPoint = endPoint + duration - 1;
//                    if (i == len - 1) ans
                }else {
                    ans += startPoint+duration-1 - endPoint +1;
                    if (i == len - 1) ans += duration;
//                    endPoint = startPoint + duration - 1;
                }
            }else if (startPoint == endPoint){
                ans += duration - 1;
                if(i == len - 1){
                    ans += duration - 1;
                }
            }
            endPoint = startPoint + duration - 1;
        }
        return ans;
    }

    public static int findPoisonedDuration1(int[] timeSeries, int duration){
        int len = timeSeries.length, ans = 0;
        for (int i = 1; i < len; i++){
            int gap = timeSeries[i] - timeSeries[i-1];
            if (gap < duration){
                ans += gap;
            }else {
                ans += duration;
            }
        }

        if (len > 0) ans += duration;
        return ans;
    }

}
