package pers.james.array.removeElement;

/**
 * 283. Move Zeroes
 * easy
 * @author JamesLiu
 * @date 2022年01月15日 18:42:00
 */
public class MoveZeros {
    /**
     * 这个解法和RemoveElements几乎一样，但是RemoveElements不关心 = val的数，所以每次找到 ！= val的数的时候，只需要赋值，不需要swap
     * 但是这题不仅要求除0外的数都在左边，0也同事必须到右边，不能直接赋值，而是swap
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(left, right, nums);
                left++;
            }
        }
    }
    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
