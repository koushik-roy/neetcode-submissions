class Solution {
    public int strStr(String haystack, String needle) {

        int[] lps = constructLps(needle);

        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else
                    i++;
            }

        }
        return -1;
    }

    public int[] constructLps(String text) {
        char[] pat = text.toCharArray();
        int[] lps = new int[text.length()];
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}