class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[r] < nums[mid]) { // left half is sorted //min is on the right-half
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
