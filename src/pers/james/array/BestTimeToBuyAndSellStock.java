package pers.james.array;

import java.util.Arrays;
import java.util.Collections;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        Integer[] profit = new Integer[len];
        for (int i = 0; i < len; i++){
            int buy = prices[i];
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < len; j++){
                if (prices[j] > max){
                    max = prices[j];
                }
            }
            if (max > buy) profit[i] = max - buy;
            else profit[i] = 0;
        }
        return Collections.max(Arrays.asList(profit));
    }
}
