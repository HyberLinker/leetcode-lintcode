package pers.james.twoPointer;

public class SortColorII {
    public void sortColors2(int[] colors, int k){
        if (colors == null || colors.length == 0) return;
        rainbowSort(colors, 0, colors.length-1, 1, k);
    }

    public void rainbowSort(int[] colors, int left, int right, int colorFrom, int colorTo){
        if (colorFrom == colorTo) return;

        if (left >= right) return;

        int colorMid = colorFrom + (colorFrom - colorTo)/2;
        int l = left, r = right;
        while (l < r){
            while (l < r && colors[l] <= colors[colorMid]) l++;
            while (l < r && colors[r] > colors[colorMid]) r--;

            if (l < r){
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }

        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, r+1, right, colorMid+1, colorTo);
    }
}
