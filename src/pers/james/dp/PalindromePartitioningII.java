package pers.james.dp;

/**
 * @author 11101526
 * @date 2021/8/20 14:51
 */
public class PalindromePartitioningII {
    /**
     * 解法一
     * @param s
     * @return
     */
    public int minCut(String s) {
        //boolean[][] palindrome   表示[i,j]是否回文
        boolean[][] palindrome = isPalindrome(s);
        int[] cut = new int[s.length()];
        cut[0] = 0;
        //cut[i] 代表考虑下标为 i 的字符为结尾的最小分割次数
        for (int i = 0; i < s.length(); i++) {
            //初始化更开始都是最大数，这样Math.min才能排除那些没有更新过的
            cut[i] = Integer.MAX_VALUE;
            if (palindrome[0][i]) {
                cut[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (palindrome[j + 1][i]) { //保证，cut 之后的后半段，[j+1,i]是回文
                    cut[i] = Math.min(cut[i], cut[j] + 1); //cut[j] 表示前半段，存在的最小分割数，使分割后的part形成回文
                }
            }
        }
        return cut[s.length()-1];
    }

    /**
     *
     * 获取整个字符串的回文序列
     * 也是一个dp
     * @param s
     * @return
     */
    private boolean[][] isPalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        for (int i = 0; i < len; i++) {//
            for (int j = i; j >= 0 ; j--) {//for (int j = i; j < len ; j++) 内部循环这么写也有问题。1.不是所有的位置都能计算到
                if (i == j) {
                    //初始化，单个字符一定回文
                    res[i][j] = true;
                    continue;
                }
                //状态转移方程
                //[i,j] 是否回文，
                // 判断i和j的字符是否相同，
                // 然后判断i+1和j-1是否回文
                boolean a = s.charAt(i) == s.charAt(j);
                boolean b = i-j >= 2 ? res[j+1][i-1] : true; //res[i+1][j-1] 这个写法有问题，j=2，i=0 时res[1][1] i+1=1,现在刚从i=0第一行开始，i=0都还没有赋值
                res[j][i] = a && b; //当[i,j]长度大于等于2，才需要看 [i+1,j-1]是否回文；不然只需要考虑s[i],s[j]是否相等即可
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcccb";
        PalindromePartitioningII a = new PalindromePartitioningII();
        int i = a.minCut1(s);
        System.out.println(i);
    }

    public int minCut1(String s) {
        boolean[][] palindrome = isPalindrome1(s);
        int length = s.length();
        //cut[i] 前i字符串需要最小cut，初始值cut[0]只存在单个字符所以是0；最终答案是cut[length-1]
        int[] cut = new int[length];
        cut[0] = 0;
        for (int i = 1; i < length; i++) {
            cut[i] = Integer.MAX_VALUE;
            if (palindrome[0][i]) {
                cut[i] = 0; //不依赖j，不需要分割，[0,i]可直接形成回文
                continue;
            }
            for (int j = i - 1; j >=0 ; j--) {
                if (cut[j] != Integer.MAX_VALUE && palindrome[j+1][i]) {
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }
        return cut[length-1];
    }

    private boolean[][] isPalindrome1(String s) {
        int length = s.length();
        boolean[][] res = new boolean[length][length];
        //初始化
        for (int i = 0; i < length; i++) {
            //长度为1，单个字符一定回文
            res[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            //长度为2，看取决这两个字符是否相同
            res[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        //状态流转
        //外循环是startIndex，内循环是长度，会超出范围；换成外循环长度，内循环startIndex
        //java.lang.StringIndexOutOfBoundsException: String index out of range: 3
        //如果外循环是start，内循环是长度，那么对于"abcccb"，当res[1,5] = res[2][4] && ... 这时res[2][4] 还没有被赋值
//        for (int start = 0; start < length; start++) {
//            for (int len = 2; start + len < length; len++) {//len 指endIndex - startIndex
//                res[start][start + len] = res[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
//            }
//        }
        for (int len = 2; len < length; len++) {
            for (int start = 0; start + len < length; start++) {//len 指endIndex - startIndex
                res[start][start + len] = res[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        return res;
    }
}
