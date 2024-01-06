class Solution {
    int[] cache;
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        cache = new int[nums.length];
        int maxLIS = 0;
        
        for(int i = 0; i < nums.length; i++){
            cache[i] = helper(nums, i);
            maxLIS = Math.max(maxLIS, cache[i]);
        }
        return maxLIS;
        
    }
    
    private int helper(int[] nums, int index){
        if(cache[index] != 0) return cache[index];
        
        int curVal = nums[index];
        int maxLIS = 0;
        
        for(int i = index + 1; i < nums.length; i++){
            if(curVal < nums[i]){
                maxLIS = Math.max(maxLIS, helper(nums, i));
            }
        }
        
        cache[index] = maxLIS + 1;
        
        return cache[index];

    }
 
}