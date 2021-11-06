package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxAve {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] nums = new int[num];
        s.nextLine();
        int a = s.nextInt();
        int b = s.nextInt();
        s.nextLine();
        for (int i = 0; i < num; i++) {
            nums[i] = s.nextInt();
        }

        int setNum = Math.min(a, b);
        List<List<Integer>> result = new ArrayList<>();
        findComb(setNum, new ArrayList<Integer>(), result, nums, 0);
//        List<List<Integer>> otherResult = new ArrayList<>();

        List<Integer> aves = calulateAve(result, setNum, nums, a, b);
        int max = -1;
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            if (aves.get(i) > max){
                max = aves.get(i);
                index = i;
            }
        }
        int[] finalResult = new int[nums.length];
        if (setNum == a){
            for (int i = 0; i < nums.length; i++) {
                for (Integer j:result.get(index)
                     ) {
                    if (i == j){
                        finalResult[i] = 1;
                    }else finalResult[i] = 2;
                }
            }
        }else if (setNum == b){
            for (int i = 0; i < nums.length; i++) {
                for (Integer j:result.get(index)
                        ) {
                    if (i == j){
                        finalResult[i] = 2;
                    }else finalResult[i] = 1;
                }
            }
        }

        for (int i = 0; i < finalResult.length - 1; i++) {
            System.out.print(finalResult[i] + " ");
        }
        System.out.print(finalResult[finalResult.length-1]);

    }
    public static List<Integer> calulateAve(List<List<Integer>> result, int setNum, int[] nums, int a, int b){
        List<Integer> aves = new ArrayList<>();
        for (List<Integer> comA:result
             ) {
            int sumA = 0;
            int sumB = 0;
            int numB = setNum == a? b:a;
            for (int i = 0; i < nums.length; i++) {
                for (Integer index:comA
                     ) {
                    if (index == i){
                        sumA += nums[i];
                    }else {
                        sumB += nums[i];
                    }
                }
            }
            int ave = sumA/setNum + sumB/numB;
            aves.add(ave);
        }
        return aves;
    }

    public static void findComb(int setNum, List<Integer> comb, List<List<Integer>> result, int[] nums, int startIndex){
        if (comb.size() == setNum){
            result.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            comb.add(i);
            findComb(setNum, comb, result, nums, startIndex+1);
            comb.remove(comb.size()-1);
        }
    }

}
