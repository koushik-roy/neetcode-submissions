class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // List<Map.Entry<Integer, Integer>> topK = list.subList(0, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=list.get(i).getKey();
        }

        return res;
    }
}
