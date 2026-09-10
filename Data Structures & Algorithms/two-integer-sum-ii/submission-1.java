class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length-1;
        int i=0, j=n;

        while(i<j && j>=0){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            }
            else if(numbers[i] + numbers[j] > target){
                j--;
            }else if(numbers[i] + numbers[j]< target){
                i++;
            }
            

        }

        return new int[]{};
    }
}