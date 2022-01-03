package pers.james.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 11101526
 * @date 2021/9/11 14:32
 */
public class QuickSort {
    //四个步骤：
    //1.比较startIndex和endIndex，更喜欢理解为校验
    //2.找出基准
    //3.左边部分排序
    //4.右边排序
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            //找出基准
            int partition = partition(arr, startIndex, endIndex);
            //分成两边递归进行
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }
    }

    //找基准
    //从两端往中间找，left找大于pivot的数，right找小于等于pivot的数，然后left和right交换
    //直到最终left 和 right位置重合
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];

        int left = startIndex;
        int right = endIndex;

        //等于就没有必要排序
        while (left != right) {

            while (left < right && arr[right] > pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //找到left比基准大，right比基准小，进行交换
            if (left < right) {
                swap(arr, left, right);
            }
        }
        //第一轮完成，让left和right重合的位置和基准交换，返回基准的位置
        swap(arr, startIndex, left);
        return left;
    }

    //两数交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 解法二
     * 思路好理解，实现复杂
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            //找出基准
            int partition = partition1(arr, startIndex, endIndex);
            //分成两边递归进行
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }
    }

    private static int partition1(int[] arr, int startIndex, int endIndex) {
        Random random = new Random();
        //nextInt(A) + B, 其中 A决定了上限（右区间），B决定了下限（左区间）
        //nextInt(X)：[0,X) = [0,X-1]    nextInt(X)+1：[1,X]
        int pivotIndex = random.nextInt(endIndex + 1 - startIndex) + startIndex;
        int pivot = arr[pivotIndex];

        //从左往右遍历。
        // 把遇到的第一个大于pivot的数和位置记录下来，然后不断的把它往右移动。
        // 再从上次的位置开始，寻找下一个大于pivot的数和位置，重复上述步骤，直到遍历结束，所有大于pivot的数都被处理过
        int pivotNew = pivot;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pivot) {
                int storePoint = i; //储存当前置换点
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] <= pivot) {
                        pivotNew = storePoint;  //当需要把小于pivot的数j置换的时候，进行pivotNew更新；保证pivotNew的数是小于pivot并且位置是最右的
                        swap(arr, storePoint, j);
                        storePoint = j;
                    }
                }

            }
        }
        return pivotNew;
    }

    public static void quickSort3(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return;
        }
        partition3(arr, start, end);
    }

    /**
     * 128 arr[leftIndex] < pivot, 如果数组数字全部相同，leftIndex 和 rightIndex都不会变化进入死循环；
     *      改进1:138,139 每次循环leftIndex++ rightIndex-- 防止两个index不变的情况；
     *      但是这种仍然会导致Stack Overflow，因为while循环中判断是leftIndex < rightIndex，没有相等情况，所以出while后两个index可能是 leftIndex > rightIndex 或者 leftIndex = rightIndex；
     *      如果是leftIndex = rightIndex,146 和 147 partition3(arr, start, leftIndex);partition3(arr, leftIndex+1, end);写法没问题，但是leftIndex > rightIndex这种情况会导致Stack Overflow，因为重复计算了
     *
     *      改进2：让while条件包括=，这样出while后就是 leftIndex < rightIndex 一种情况，然后调整146 和 147
     *
     *
     * 128 arr[leftIndex] <= pivot, 如果数组数字全部相同。第一次partition会把所有数放到左边，导致partition之后数组长度没有变化，进入Stack Overflow
     * @param arr
     * @param start
     * @param end
     */
    private static void partition3(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[(start+end)/2];
        int leftIndex = start;
        int rightIndex = end;
        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && arr[leftIndex] < pivot) { //这里arr[leftIndex] < pivot，表示如果和pivot相同也要移动；但是如果数组中的数全部相同，这里两个while循环都进不去，left和right一直不会变化，进入了死循环
                leftIndex++;
            }
            while (leftIndex <= rightIndex && arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        partition3(arr, start, rightIndex);
        partition3(arr, leftIndex, end);
    }

    /**
     * 以quickSort3 解法为准
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 9, 6}; //1, 1, 1, 1, 1, 1
        quickSort3(a, 0, a.length - 1);
        //输出结果
        System.out.println(Arrays.toString(a));
    }


}
