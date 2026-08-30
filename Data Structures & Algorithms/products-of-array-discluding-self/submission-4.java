class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int prefix[] = new int[l];
        int suffix[] = new int[l];
        int res[] = new int[l];

        prefix[0] = 1;
        int productPrefix = 1;
        for (int i = 1; i < l; i++) {
            productPrefix = productPrefix * nums[i - 1];
            prefix[i] = productPrefix;
        }
        suffix[l - 1] = 1;
        int productSuffix = 1;
        for (int j = l - 2; j >= 0; j--) {
            productSuffix = productSuffix * nums[j + 1];
            suffix[j] = productSuffix;
        }
        for (int k = 0; k < res.length; k++) {
            res[k] = prefix[k] * suffix[k];
        }
        return res;
    }
}
