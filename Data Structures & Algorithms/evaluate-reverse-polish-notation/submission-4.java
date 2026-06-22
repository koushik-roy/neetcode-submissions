class Solution {
    public int evalRPN(String[] tokens) {

        if(tokens.length<=1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> st = new Stack<>();

        int eval = 0;

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                int op1 = Integer.parseInt(st.pop());
                int op2 = Integer.parseInt(st.pop());

                System.out.printf("Op1: %d and Op2: %d\n", op1, op2);
                if (s.equals("+")) {
                    eval = op1 + op2;
                } else if (s.equals("-")) {
                    eval = op2 - op1;
                } else if (s.equals("*")) {
                    eval = op1 * op2;
                } else if (s.equals("/")) {
                    eval = op2 / op1;
                }

                st.push(String.valueOf(eval));
            } else
                st.push(s);
        }

        return eval;
    }
}
