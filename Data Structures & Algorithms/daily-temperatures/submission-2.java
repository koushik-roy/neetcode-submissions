class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int l = temperatures.length;
        int[] res = new int[l];

        for (int i = 0; i < l; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                System.out.println(s.peek());
                res[s.peek()] = i - s.pop();
            }

            s.push(i);
        }

        return res;
    }
}
