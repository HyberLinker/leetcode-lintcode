package pers.james.twoPointer;

public class RotateString {
    public boolean rotateString(String A, String B) {
        String temp = A + A;
        return A.length() == B.length()&&temp.contains(B);
    }
}
