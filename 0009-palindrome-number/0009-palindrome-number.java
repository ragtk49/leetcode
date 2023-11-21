class Solution {
    public boolean isPalindrome(int x) {
        String a = Integer.toString(x);
        
        int left = 0; int right = a.length() - 1;
        while(left < right){
            if(a.charAt(left) != a.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}