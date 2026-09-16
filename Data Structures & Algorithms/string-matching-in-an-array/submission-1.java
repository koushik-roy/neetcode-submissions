class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
         for(String word: words){
            for(String compare: words){
                if(word.equals(compare)){
                    continue;
                }
                if(compare.contains(word)){
                    set.add(word);
                }
            }
         }

         return new ArrayList(set);
    }
}