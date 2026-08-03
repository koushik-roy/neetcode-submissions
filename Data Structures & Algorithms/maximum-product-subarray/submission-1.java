class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int answer = nums[0];
        int oldMax = max;
        int oldMin = min;
        for (int i = 1; i < nums.length; i++) {
            int newMax = Math.max(nums[i], Math.max(oldMax * nums[i], oldMin * nums[i]));
            int newMin = Math.min(nums[i], Math.min(oldMax * nums[i], oldMin * nums[i]));
            oldMax = newMax;
            oldMin = newMin;
            answer = Math.max(answer, newMax);
        }

        return answer;
    }
}
