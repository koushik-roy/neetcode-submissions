class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        int i = n;
        int count = 0;
        if(n==0){
            return 1;
        }
        if (s.charAt(i) == ' ') {
            while (s.charAt(i) == ' ') {
                i--;
            }
        }

        while (s.charAt(i) != ' ' && i>0) {
            count++;
            i--;
        }

        return count;
    }
}