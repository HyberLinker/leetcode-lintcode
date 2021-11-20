package pers.james.string;

public class HashFunction {
    /**
     * 说一下需要注意的两个点
     * 1. 循环遍历字符的时候，只遍历到 len - 2 的下标，就是留下最后一个字符不遍历。
     *      这样才能让所有33的次数符合要求，最大次数 = len - 1
     *
     * 2. 由于int长度有限，所以在循环中有可能会出现越界，变成负数；导致下面那个测试用例跑不通
     *      所以改成long型，最后做强转
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public static int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long hashCode = 0;
        for (int i = 0; i < key.length - 1; i++) {
            hashCode = ((hashCode + key[i]) * 33) % HASH_SIZE;
        }
        hashCode = (hashCode + key[key.length - 1]) % HASH_SIZE;
        return (int)hashCode;
    }

    public static void main(String[] args) {
        String s = "Wrong answer or accepted?";
        int hashSize = 1000000007;
        System.out.println(hashCode1(s.toCharArray(), hashSize));
    }

    /**
     * 循环中 * 33 的被乘数不同
     * @param key
     * @param HASH_SIZE
     * @return
     */
    public static int hashCode1(char[] key, int HASH_SIZE) {
        // write your code here
        long hashCode = 0;
        for (int i = 0; i < key.length; i++) {
            hashCode = (hashCode * 33 + key[i]) % HASH_SIZE;
        }
        return (int)hashCode;
    }
}
