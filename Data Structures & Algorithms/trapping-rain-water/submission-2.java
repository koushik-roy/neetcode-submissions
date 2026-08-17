class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int bottom = 0, left = 0, right = 0, width = 0, water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                bottom = st.pop();

                if (!st.isEmpty()) {
                    left = st.peek();
                    right = i;
                    water += (Math.min(height[left], height[right]) - height[bottom])
                        * (right - left - 1);
                }
            }
            st.push(i);
        }

        return water;
    }
}