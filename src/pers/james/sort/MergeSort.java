package pers.james.sort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr, int startIndex, int endIndex) {
        int[] temp = new int[arr.length];
        mergeSort(arr, startIndex, endIndex, temp);
    }
    public void mergeSort(int[] arr, int startIndex, int endIndex, int[] temp) {
        System.out.printf("startIndex:{%d}, endIndex:{%d}\n", startIndex, endIndex);
        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;
        mergeSort(arr, startIndex, midIndex, temp);
        mergeSort(arr, midIndex + 1, endIndex, temp);
        merge(arr, startIndex, endIndex, midIndex, temp);
        System.out.printf("arr:{%s}\n", Arrays.toString(arr));
    }

    /**
     * merge 就是合并左右两个数组，left和right数组都是有序的；
     * 把两个有序数组合并，使用同向双指针，leftStartIndex 和 rightStartIndex进行对比，把小的放到数组中
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @param midIndex
     * @param temp
     */
    private void merge(int[] arr, int startIndex, int endIndex, int midIndex, int[] temp) {
        //left数组最左边的数是 startIndex，最右边的数是midIndex
        //right数组最左边的数只midIndex + 1，最后边是endIndex
        int index = startIndex;
        int rightStartIndex = midIndex + 1;
        int leftStartIndex = startIndex;
        //while循环，直到left数组或者right数组都已经被放到temp中，符合其中一个就退出
        while (leftStartIndex <= midIndex && rightStartIndex <= endIndex) { //left数组的start <= end, right数组的start <= end
            if (arr[leftStartIndex] <= arr[rightStartIndex]) {
                temp[index++] = arr[leftStartIndex++];
            }else {
                temp[index++] = arr[rightStartIndex++];
            }
        }
        //double check
        //看left数组是否还有剩余，可以直接接在数组右侧
        while (leftStartIndex <= midIndex) {
            temp[index++] = arr[leftStartIndex++];
        }
        //double check
        //看right数组是否还有剩余，可以直接接在数组右侧
        while (rightStartIndex <= endIndex) {
            temp[index++] = arr[rightStartIndex++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            //把排完序的数组再捯饬回去，arr和temp来回捯饬，temp先更新，然后把更新的数组拷贝回arr
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 9, 6}; //1, 1, 1, 1, 1, 1
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, a.length - 1);
        //输出结果
        System.out.println(Arrays.toString(a));

    }
}
