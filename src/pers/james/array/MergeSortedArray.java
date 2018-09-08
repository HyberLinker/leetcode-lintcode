package pers.james.array;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {2,3,0,0,0,0,0};
        int[] nums2 = {1,1,2,5,6};
//        merge(nums1, 3, nums2, 3);
    }
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i=m-1;
//        int j=n-1;
//        int k = m+n-1;
//        while(i >=0 && j>=0)
//        {
//            if(nums1[i] > nums2[j])
//                nums1[k--] = nums1[i--];
//            else
//                nums1[k--] = nums2[j--];
//        }
//        while(j>=0)
//            nums1[k--] = nums2[j--];
//    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                k--;
                j--;
            }else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }

        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
