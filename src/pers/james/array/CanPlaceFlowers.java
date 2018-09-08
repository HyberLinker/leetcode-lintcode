package pers.james.array;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,1,0,1,0,1};
        System.out.println(canPlaceFlowers(flowerbed,0));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, count = 0;
        if (len == 1 && flowerbed[0] == 0) return true;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            if (++count == n) return true;
        }

        for (int i = 1; i < len - 1; i++){
            if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                if (++count == n) return true;
            }
        }
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0){
            flowerbed[len - 1] = 1;
            if (++count == n) return true;
        }
        return false;
    }
}
