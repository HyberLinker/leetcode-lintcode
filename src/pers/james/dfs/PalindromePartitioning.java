package pers.james.dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) return result;
        if (s.length() == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        getIsPalindrome(s);
//        getPalindrome(s);
//        help(s, 0, new ArrayList<String>(), result);
        helper(s, 0, new ArrayList<String>(), result);
        return result;
    }

    /**
     * help 和 helper唯一不同的地方，是对于palindrome的处理
     * help调用了isPalindrome方法
     * helper调用了getIsPalindrome方法的结果，复杂度会更低
     * @param s
     * @param startIndex
     * @param combination
     * @param result
     */
    private void help(String s, int startIndex, List<String> combination, List<List<String>> result) {
        if (startIndex == s.length()){
            result.add(new ArrayList<String>(combination));
            return;
        }
        for (int i = startIndex; i < s.length(); i++){
            String sub = s.substring(startIndex, i + 1);

            if (!isPalindrome(sub)) continue;

            combination.add(sub);
            help(s, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }

    }

    private boolean isPalindrome(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--){
            if (sub.charAt(i) != sub.charAt(j)) return false;
        }
        return true;
    }
    

    private void helper(String s, int startIndex, List<String> partition, List<List<String>> result){
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partition));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome[startIndex][i]) continue;
            String sub = s.substring(startIndex, i+1);

            partition.add(sub);
            helper(s, i+1, partition, result);
            partition.remove(partition.size()-1);
        }
    }

    private void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    private void getPalindrome(String s){
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n - 1 ; i++) {
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        /**
         * 这样循环赋值有问题，应该从后向前，具体哪里有问题没搞懂
         */
        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = (isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j));
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        List<List<String>> result = p.partition("cbbbcc");
        for (List<String> l:result
             ) {
            for (String s:l
                 ) {
                System.out.print("-"+s);
            }
            System.out.println();
        }
    }

}
