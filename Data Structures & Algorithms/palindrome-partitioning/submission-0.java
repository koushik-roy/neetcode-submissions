class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        backtrack(s, curr, 0);
        return res;
    }

    public void backtrack(String s, List<String> curr, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(s.substring(index, end + 1))) {
                curr.add(s.substring(index, end + 1));

                backtrack(s, curr, end + 1);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}
