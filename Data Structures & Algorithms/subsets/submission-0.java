class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums, current);
        return result;
    }

    public void backtrack(int start, int[] nums, List<Integer> current) {      
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i+1, nums, current);
            current.remove(current.size() - 1);
        }
    }
}
