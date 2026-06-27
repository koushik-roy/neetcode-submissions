class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, curr, 0, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> curr, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target) {
            return;
        }
        Arrays.sort(candidates);
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            curr.add(candidates[i]);
            backtrack(candidates, target, curr, candidates[i] + sum, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
