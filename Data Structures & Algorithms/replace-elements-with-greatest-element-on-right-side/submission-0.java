class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int n = arr.length;
        // int[] res = new int[n];
        // res[n - 1] = -1;

        int i = n-1;
        while (i>=0) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
            i--;    
        }
        
        return arr;
    }
}