package pers.james.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 11101526
 * @date 2021/4/19 17:08
 */
public class WordBreak {
    /**
     * dp[i],前i个字符是否可以wordbreak
     * dp的长度必须是s.length() + 1
     * 如果是s.length()，那么意味着这一刀是在index后，比如dp[0]，就把s分成l|eetcode；这个时候dp[0] = false
     * 那么，当i=3,j=0 时，[j,i) 分割出leet，这个时候dp[j] && isContains(s.substring(j, i), wordDict 这个判断会变成false，肯定就不对；
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[0] 表示把s分成 |leetcode，两部分，这一刀是切在index=0前面；
        //dp[1] 表示把s分成 l|eetcode，两部分，这一刀是切在index=1前面；
        //dp的长度需要s.length() + 1，因为最后一刀需要在 index = s.length() - 1 后面，所以最后一个数需要是index = s.length()，长度自然就是 s.length() + 1
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //dp[0] 表示前面的空气，就把wordDict当做 ["leet","code",""]就行
        int maxLen = getMaxLen(wordDict);
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //TODO 这个剪枝的逻辑那里有问题？-- 没有问题
                if (i - j > maxLen) {
                    continue;
                }
                if (dp[j] && isContains(s.substring(j, i), wordDict)) {
                    dp[i] = true;
                    break; //这个break不能丢，不然后面会再进行判断把之前的结果覆盖掉
                }
            }
        }

        return dp[s.length()];
    }

    private int getMaxLen(List<String> wordDict) {
        return wordDict.stream().max(Comparator.comparing(String::length)).get().length();
    }

    private boolean isContains(String s, List<String> wordDict) {
        return wordDict.contains(s);
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
}
