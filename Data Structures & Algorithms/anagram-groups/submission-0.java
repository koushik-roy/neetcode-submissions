class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<int[], String> map = new HashMap<>();
        List<String> inner = new ArrayList<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            map.put(freq, s);
            System.out.println(s + ":" + Arrays.toString(freq));
        }

        Map<String, List<String>> groupedMap =
            map.entrySet().stream().collect(Collectors.groupingBy(entry
                -> Arrays.toString(entry.getKey()),
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        List<List<String>> outer = new ArrayList<>(groupedMap.values());
        return outer;
    }
}
