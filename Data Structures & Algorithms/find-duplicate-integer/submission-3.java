class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value=Math.abs(nums[i]);
            int index=value-1;
            if (nums[index] < 0) {
                return value;
            } else {
                nums[index] *= -1;
            }
        }
        return -1;
    }
}
