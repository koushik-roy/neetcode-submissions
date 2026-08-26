class Solution {
    public boolean canJump(int[] nums) {
        int maxFar = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxFar) { // unreachable index
                return false;
            }
            maxFar = Math.max(maxFar, i + nums[i]);
        }

        return maxFar >= nums.length - 1;
    }
}
