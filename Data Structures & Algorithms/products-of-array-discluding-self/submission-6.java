class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        // int prefix[] = new int[l];
        // int suffix[] = new int[l];
        int res[] = new int[l];

        // prefix[0] = 1;
        int productPrefix = 1;
        for (int i = 0; i < l; i++) {
            res[i] = productPrefix;
            productPrefix = productPrefix * nums[i];
        }
        // suffix[l - 1] = 1;
        int productSuffix = 1;
        for (int j = l -1; j >= 0; j--) {
            res[j] *= productSuffix;
            productSuffix *= nums[j];
        }
        
        return res;
    }
}
