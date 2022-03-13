package pers.james.array.removeElement;

/**
 * 27. Remove Element
 * esay
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        removeElement(nums, val);

    }
    public static int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else i++;          //i++必须要在if里面，如果最后一个数==val，当他被换到第一个位置时，还需要再check一边第一个位置，所以不能每次循环都i++
        }
        return n;
    }

    /**
     * 2022.1.15
     * 可以使用双指针：右指针 right 指向当前将要处理的元素，左指针 left 指向下一个将要赋值的位置。
     *
     * 如果右指针指向的元素不等于 val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
     *
     * 如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。
     *
     * 整个过程保持不变的性质是：区间[0,left) 中的元素都不等于 val。当左右指针遍历完输入数组以后，left 的值就是输出数组的长度。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode-solution-svxi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 等于val的数，我们不关心，关心的是那些不等于val的数。
     * 所以right是查看下一个数，left是记录下一个不等于val的数
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                //right指向的数 不等于 val，把left所在位置的数设置成right所在位置的数，并且left前进一位
                nums[left++] = nums[right];
            }
            //right 指向的数 == val，right向前一位，去寻找下一个非val的数
        }
        return left; //这里不是left+1，因为left表达的是存储的是下一个非val的index
    }
}
