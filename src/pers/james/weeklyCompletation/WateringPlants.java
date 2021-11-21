package pers.james.weeklyCompletation;

public class WateringPlants {
    public static int wateringPlants(int[] plants, int capacity) {
        int leftCapacity = capacity;
        int index = 0;
        int ans = 0;
        while (index <= plants.length - 1) {
            if (leftCapacity >= plants[index]) {
                leftCapacity -= plants[index];
            }else {
                ans += 2 * (index - 1 - (-1));  //这个地方需要归纳下；人在当前点的前一个点审视当前点，所以要index-1， -1是取水点，步长就是 index - 1 -(-1)
                leftCapacity = capacity - plants[index]; //这个表示从取水地盛满水后，进行了当前点的灌溉
            }
            ans++;  //移动到下一个灌溉点
            index++; //看下个灌溉点
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacity = 5;
        System.out.println(wateringPlants(plants, capacity));
    }
}
