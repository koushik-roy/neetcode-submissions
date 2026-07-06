class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int i : piles) {
            right = i > right ? i : right;
        }
        int ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = 0;

            for (int i : piles) {
                time += (i + mid - 1) / mid;
            }

            if (time <= h) { // drop rate, go left
                right = mid - 1;
                ans = mid;
            } else { // increase rate
                left = mid + 1;
            }
        }

        return ans;
    }
}
