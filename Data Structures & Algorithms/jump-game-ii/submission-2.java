class Solution {
    public int jump(int[] nums) {
        int farthest = 0, currEnd = 0, jump = 0;
        if(nums.length<=1){
            return jump;
        }
        int i = 0;
        while (i < nums.length) {
            farthest = Math.max(farthest, i + nums[i]);

            if (currEnd == i) {
                jump++;
                currEnd = farthest;
            }

            if (currEnd >= nums.length-1) {
                return jump;
            }

            i++;
        }
        return -1;
    }
}
