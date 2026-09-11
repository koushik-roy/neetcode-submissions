class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0, i = 0, j = n - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);
            if (height[i] > height[j]) {
                j--;
            } else
                i++;
        }

        return maxArea;
    }
}