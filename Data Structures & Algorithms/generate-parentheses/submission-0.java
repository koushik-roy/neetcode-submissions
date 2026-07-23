class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb);
        return res;
    }

    public void backtrack(int n, int open, int close, StringBuilder curr) {
        if (open == n && close == n) {
            res.add(curr.toString());
            return;
        }

        if (open < n) {
            backtrack(n, open + 1, close, curr.append("("));
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            backtrack(n, open, close + 1, curr.append(")"));
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
