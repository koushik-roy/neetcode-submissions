class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int i = 0;
        while (i < nums.length) {
            if (i - k - 1 >= 0 && i >= k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            i++;
        }

        return false;
    }
}