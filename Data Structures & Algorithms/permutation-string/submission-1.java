class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int freq1[] = calcFreq(s1);

        int windowSize = s1.length(), l = 0, r = l + windowSize;
        while (r <= s2.length() ) {
            String window = s2.substring(l, r );
            System.out.printf("l: %d, r: %d, window: %s%n", l, r, window);
            int[] freq2 = calcFreq(window);
            if (!Arrays.equals(freq1, freq2)) {
                l++;
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] calcFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }
}
