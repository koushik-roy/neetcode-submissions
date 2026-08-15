class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];
        Stack<Double> st = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getKey().compareTo(a.getKey()));

        for (int i = 0; i < n; i++) {
            time[i] = (double)(target - list.get(i).getKey()) / list.get(i).getValue();
        }

        for (double t : time) {
            if (st.isEmpty() || st.peek() < t) {
                st.add(t);
            }
        }
        return st.size();
    }
}
