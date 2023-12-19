class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = 1;
        for(int i = 1; i < nums.length; i++){
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }
        
        rightArr[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            rightArr[i] = rightArr[i + 1] * nums[i + 1];
        }
        
        int[] res = new int[n];
        
        for(int i = 0; i < res.length; i++){
            res[i] = leftArr[i] * rightArr[i];
        }
        
        return res;
    }
}