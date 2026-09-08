class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == 0 || i >= strs[j].length()
                    || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return s.toString();
                }
            }
            s.append(strs[0].charAt(i));
        }

        return s.toString();
    }
}