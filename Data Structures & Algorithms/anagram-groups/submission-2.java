class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> outer= new ArrayList<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(freq);
            List<String> inner = new ArrayList<>();
            if (!map.containsKey(key)) {
                inner.add(s);
                map.put(key, inner);
            } else {
                inner = map.get(key);
                inner.add(s);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " => " + value));
        map.forEach((key, value) -> outer.add(value));
        return outer;
    }
}
