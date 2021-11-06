package interview;

public class BuyOrange {
    public int fun(int num){
        int[] minBugNum = new int[1];
        minBugNum[0] = num;
        solve(num, 0, minBugNum);
        return minBugNum[0];
    }
    public void solve(int num, int bagNum, int[] minBugNum){
        if (num == 0) {
            int newMin = Math.min(bagNum, minBugNum[0]);
            minBugNum[0] = newMin;
            return;
        }

        if (num < 6) return;


        solve(num - 6, bagNum + 1, minBugNum);
        solve(num - 8, bagNum + 1, minBugNum);
    }

    public static void main(String[] args) {
        BuyOrange b = new BuyOrange();
        int result = b.fun(20);
        System.out.println(result == 20 ? -1 : result);
    }
}
