package pers.james.company.meituan;

/**
 * 2022.3.12 美团笔试第一题
 * 判断数字是否至少满足一下两个特征的一种：
 * 1. 数字是11的整数倍
 * 2. 数字中至少包含两个1
 * 是则输出“yes”, 否则输出“no”
 * @author JamesLiu
 * @date 2022年03月19日 17:36:00
 */
public class IntegerSatisfyCondition {
    public void solution(int num) {
        //1. 数字是11的整数倍
        if (num % 11 == 0) {
            //取余如果可以整除，余数为0
        }
        //2. 数字中至少包含两个1；可以转化成string然后遍历判断。
        // 或者每次对10取余，余数就是个位的数字。（对10取余，余数一定是0-9）然后再除以10，相当于左移一位
        int frequency = 0;
        int temp = num;
        if (temp > 0) {
            if (temp % 10 == 1) {
                frequency++;
            }
            temp = temp / 10;
        }
    }
}
