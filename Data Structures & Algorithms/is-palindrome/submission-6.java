class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
        System.out.println(s);

        int i =0;
        int j=s.length()-1;
    
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
