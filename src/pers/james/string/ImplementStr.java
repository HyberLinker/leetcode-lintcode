package pers.james.string;

public class ImplementStr {
    /**
     * 解法一
     * o（mn）
     * pass
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - 1 - i + 1 < needle.length()) { // 这个地方不做剪枝，就会超时
                return 0;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (i + j > haystack.length() - 1) { //index out of
                    break;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 能过的o（mn）解法
     * pass
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            if (haystack.length() - i < needle.length()) { // 这个判断好难想；剩下的长度（终点-起点+1：len - 1 - i + 1），是否<needle的长度
                return -1;
            }
            int start = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return start;
                }
                i++;
            }
            i = start;
        }
        return -1;
    }

    /**
     * robin karp 算法
     * 利用hashcode 达到 o（n）
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        //获取目标hashcode
        long needleCode = 0;
        int hashSize = 100000;
        for (int i = 0; i < needle.length(); i++) {
            needleCode = (needleCode * 33 + needle.charAt(i)) % hashSize;
        }

        //获取需要减去数的幂级数
        int pow = 1;
        for (int i = 0; i < needle.length() - 1; i++) { //这里次数要比长度小一，以为最左侧的数幂级数总是比次数小1
            pow = (pow * 33) % hashSize; //这个地方不取hash会影响结果，不单单是int超范围的事情。应该是会影响114
        }

        long hayStackCodePartly = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //先加够长度
            hayStackCodePartly = (hayStackCodePartly * 33 + haystack.charAt(i)) % hashSize;
            if (i - 0 + 1 < needle.length()) {
                continue;
            }
            //判断hashCode
            int startIndex = i + 1 - needle.length();
            if (hayStackCodePartly == needleCode) {
                if (haystack.substring(startIndex, i + 1).equals(needle)) {
                    return startIndex;
                }
            }
            //减去最左侧
            hayStackCodePartly = (hayStackCodePartly - haystack.charAt(startIndex) * pow) % hashSize;
            if (hayStackCodePartly < 0) { //防止减去之后出现负数
                hayStackCodePartly += hashSize;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr2(haystack, needle));
    }
}
