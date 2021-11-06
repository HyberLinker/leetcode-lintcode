package interview.wangyi;

import java.util.*;

public class BasketballTeamAandB {
    ArrayList<Integer> team = new ArrayList<>();
    int sum = 0;
    //    int result = 0;
    public int process(int[] value){
//        Integer result = new Integer(0);
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(value);
        for (int i = 0; i < value.length; i++){
            team.add(value[i]);
            sum += value[i];
        }
        helper(value, 0, new ArrayList<Integer>(), 0, sum, result);
        return result.get(0);

    }

    public void helper(int[] value, int startIndex, ArrayList<Integer> teamA, int sumA, int sumB, ArrayList<Integer> result){
        /**
         * 递归出口， 满足两个条件
         * 1. A队之和 > B队之和
         * 2. A队任意一个放进B队，sumA < sumB
         *
         */
        if (sumA > sumB && isCorrected(teamA, sumA, sumB)){
            if (!result.isEmpty()){
                result.add(0, result.get(0) + 1);
            }else result.add(1);
            return;
        }

        for (int i = startIndex; i < value.length; i++){
            /**
             * 剪枝
             * 如果此时sumA >= sumB, 当下次递归的时候，从B选出一个放进A，任然是sumA >= sumB，假设放进A的是m。
             * 那么，根据题中第二个条件，选m从A放进B，仍然保持，sumA >= sumB，和条件二矛盾
             */
            if (sumA >= sumB) break;

            teamA.add(value[i]);
            /**
             * 每层的sumA，sumB需要保持不变，但是递归的下一层，是要变化的。变是发生在下一层进入的时候，不能在这一层。
             * 比如，sumA在每一层中都会 +value[]i，但是，只能写在递归的入口 helper（）
             */
//            sumA += value[i];
            helper(value, i + 1, teamA, sumA + value[i], sumB - value[i], result);
            teamA.remove(teamA.size() - 1);
        }

    }

    private boolean isCorrected(ArrayList<Integer> teamA, int sumA, int sumB) {

        for (Integer i: teamA){
            int aminus = sumA - i;
            int badd = sumB + i;
            if (aminus >= badd) return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] value = new int[n];
//        for (int i = 0; i < n; i++){
//            value[i] = in.nextInt();
//        }
        BasketballTeamAandB b = new BasketballTeamAandB();
        int[] value = {7, 6, 5, 4};
        int r = b.process(value);
        System.out.println(r);
    }
}
