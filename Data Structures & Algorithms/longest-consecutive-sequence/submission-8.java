class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        for (int i : set) {
            int count = 1;
            if (!set.contains(i - 1)) {
                while (set.contains(i + count)) {
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
