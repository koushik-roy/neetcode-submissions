class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int[] suffixMax = new int[l];
        int[] prefixMax = new int[l];

        int maxP = height[0];
        for (int i = 0; i < l; i++) {
            if (height[i] >= maxP) {
                maxP = height[i];
            }
            prefixMax[i] = maxP;
        }

        int maxS = height[l - 1];
        for (int i = l - 1; i >= 0; i--) {
            if (height[i] >= maxS) {
                maxS = height[i];
            }
            suffixMax[i] = maxS;
        }



        int totalWater = 0;
        for (int i = 0; i < l; i++) {
            totalWater += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return totalWater;
    }
}
