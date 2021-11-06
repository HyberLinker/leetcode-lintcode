package pers.james.twoPointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.equals("")) return true;
        String t = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        for (; start < end; start++, end--) {
            char i = t.charAt(start), j = t.charAt(end);
            while (!Character.isLetter(i) && !Character.isDigit(i) && start < end){
                i = t.charAt(++start);
            }
            while (!Character.isLetter(j) && !Character.isDigit(j) && start < end){
                j = t.charAt(--end);
            }
            if (start == end) return true;
            if (i != j) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("ab2a"));
    }
}
