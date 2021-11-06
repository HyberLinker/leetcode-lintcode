package interview.wangyi;

import java.util.*;

public class CardScore {
    public int solution(String cards, int k){
        int result = 0;
        Map<Character, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < cards.length(); i++) {
            char curt = cards.charAt(i);
            if (!cardMap.containsKey(curt)) cardMap.put(curt, 1);
            else cardMap.put(curt, cardMap.get(curt) + 1);
        }

        List<Integer> nums = new ArrayList<>();
        for (Integer i:cardMap.values()
             ) {
            nums.add(i);
        }

        Collections.sort(nums);


        for (int i = nums.size() - 1; i >= 0 ; i--) {
            int curt = nums.get(i);
            if (curt >= k){
                result += k*k;
                break;
            }else {
                k -= curt;
                result += curt*curt;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CardScore c = new CardScore();
        String cards = "DZFDFZDFDDDDDDF";
        System.out.println(c.solution(cards, 10));
    }
}
