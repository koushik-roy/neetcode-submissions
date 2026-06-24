class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.add(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                switch (c) {
                    case ')':
                        if (!st.isEmpty() && st.peek().equals('(')) {
                            st.pop();
                        } else
                            return false;
                        break;
                    case '}':
                        if (!st.isEmpty() && st.peek().equals('{')) {
                            st.pop();
                        } else
                            return false;
                        break;
                    case ']':
                        if (!st.isEmpty() && st.peek().equals('[')) {
                            st.pop();
                        } else
                            return false;
                        break;
                }
            }
        }

        return st.isEmpty();
    }
}
