class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1 && t.length() == 1) {
            if (s.charAt(0) != t.charAt(0)) {
                return false;
            } else
                return true;
        }
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                j++;
            } else if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }

        }

        if (i > s.length() - 1) {
            return true;
        }
        return false;
    
    }
}