class Solution {
    int maxLen, start;
    public String longestPalindrome(String s) {
        int n = s.length();

        // odd center
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLen) {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }
        }

        // even center
        for (int i = 0; i < n - 1; i++) {
            int left = i;
            int right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLen) {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
