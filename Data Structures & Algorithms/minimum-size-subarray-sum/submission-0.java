class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = 1111111;
        int i = 0, j = 0;
        int n = nums.length;
        int sum = 0;

        //sum>=target

        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return minLen == 1111111 ? 0 : minLen;
    }
}