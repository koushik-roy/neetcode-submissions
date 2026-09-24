class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        // Map<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) - 1);
        }


        for(int i: sMap.values()){
            if(i!=0){
                return false;
            }
        }

        return true;
    

    }
}