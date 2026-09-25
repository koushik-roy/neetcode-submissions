class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> set = new HashSet<>();

        while (!set.contains(temp)) {
            int sum = 0;
            set.add(temp);
            while (temp > 0) {
                // int sum = 0;
                int rem = temp % 10;
                sum += rem * rem;
                temp /= 10;
            }
            if (sum != 1) {
                temp = sum;
            } else
                return true;
            System.out.println(sum);
        }
        return false;
    }
}