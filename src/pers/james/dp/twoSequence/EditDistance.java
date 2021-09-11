package pers.james.dp.twoSequence;

/**
 * @author 11101526
 * @date 2021/9/2 20:46
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        //dp[i][j] word1的前i个字符 和 word2的前j个字符，形成最小变化
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            //word1 的前i个字符匹配word2的前0个字符，word1需要都删掉
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1 ; j++) {
                dp[i][j] = dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1); //这个三元运算符，竟然优先级比+还低
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1, word2));
    }
}
