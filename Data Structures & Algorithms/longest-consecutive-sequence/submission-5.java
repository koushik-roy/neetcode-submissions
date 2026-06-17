class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>(); 
        for (int num : nums) {
            set.add(num);
        }

        int count = 1, maxCount = count;
        for (int num : set) {
            if (set.contains(num - 1)) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
