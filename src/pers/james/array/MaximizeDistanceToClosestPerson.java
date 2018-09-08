package pers.james.array;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0};
        System.out.println(maxDistToClosest(seats));
    }
    public static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] left = new int[len], right = new int[len];

        if (seats[0] == 0) left[0] = len;
        else left[0] = 0;

        if (seats[len - 1] == 0) right[len - 1] = len;
        else right[0] = 0;

        for (int i = 1; i < len; i++){
            if (seats[i] == 0){
                left[i] = left[i - 1] + 1;
            }else left[i] = 0;
        }

        for (int i = len - 2; i >= 0; i--){
            if (seats[i] == 0){
                right[i] = right[i + 1] + 1;
            }else right[i] = 0;
        }

        int ans = 0;
        for (int i = 0; i < len; i++){
            if (seats[i] == 0){
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }
}
