class Solution {
    int nums[];
    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int l = nums.length;

        k = k % l;

        reverse(0, l - 1);
        reverse(0, k - 1);
        reverse(k, l - 1);
    }

    public void reverse(int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}