class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(nums, cr, used);
        return rs;
    }

    public void backtrack(int[] nums, List<Integer> cr, boolean[] used) {
        if (cr.size() == nums.length) {
            rs.add(new ArrayList<>(cr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            cr.add(nums[i]);
            backtrack(nums, cr, used);
            used[i] = false;
            cr.remove(cr.size() - 1);
        }
    }
}
