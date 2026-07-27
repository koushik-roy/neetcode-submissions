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
            if (isPalindrome(s, index, end)) {
                curr.add(s.substring(index, end + 1));

                backtrack(s, curr, end + 1);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
