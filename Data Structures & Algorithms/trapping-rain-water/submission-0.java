class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int[] suffixMax = new int[l];
        int[] prefixMax = new int[l];

        prefixMax[0] = 0;
        int maxP = height[0];
        for (int i = 1; i < l; i++) {
            if (height[i] > maxP) {
                prefixMax[i] = 0;
                maxP = height[i];
            } else {
                prefixMax[i] = maxP;
            }
        }

        suffixMax[l - 1] = 0;
        int maxS = height[l - 1];

        for (int i = l - 2; i >= 0; i--) {
            if (height[i] > maxS) {
                suffixMax[i] = 0;
                maxS = height[i];
            } else {
                suffixMax[i] = maxS;
            }
        }

        System.out.println(Arrays.toString(prefixMax));
        System.out.println(Arrays.toString(suffixMax));

        int totalWater = 0;
        for (int i = 0; i < l; i++) {
            if(suffixMax[i]==0 || prefixMax[i]==0){
                continue;
            }
            totalWater += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return totalWater;
    }
}
