package pers.james.dp.palindrome;

public class LongestPalindromicSubstring {
    /**
     * dp 解法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        //status
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int resStartIndex = 0;
        int resEndIndex = 0;
        //initial
        for (int i = 0; i < s.length(); i++) {
            //长度为1
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            //长度为2
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1] && resEndIndex - resStartIndex + 1 < 2) {
                resStartIndex = i;
                resEndIndex = i + 1;
            }
        }
        //transfer
        for (int size = 3; size <= s.length() ; size++) {
            for (int startIndex = 0; startIndex <= s.length() - size; startIndex++) {
                int endIndex = size + startIndex - 1;
                isPalindrome[startIndex][endIndex] = isPalindrome[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex);
                //记录更新长度
                if (isPalindrome[startIndex][endIndex]) {
                    if (size > resEndIndex - resStartIndex + 1) {
                        resStartIndex = startIndex;
                        resEndIndex = endIndex;
                    }
                }
            }
        }
        return s.substring(resStartIndex, resEndIndex + 1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
