class Solution {
    int[][] cache;
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        cache = new int[nums.length][nums.length + 1];
        
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        // Call the helper for the last index
        return helper(nums, nums.length - 1, nums.length);
    }
    
    private int helper(int[] nums, int index, int prevIndex){
        if (index < 0) return 0;
        if (cache[index][prevIndex] != -1) return cache[index][prevIndex];

        int taken = 0;
        if (prevIndex == nums.length || nums[index] < nums[prevIndex]) {
            taken = 1 + helper(nums, index - 1, index);
        }
        int notTaken = helper(nums, index - 1, prevIndex);

        cache[index][prevIndex] = Math.max(taken, notTaken);
        
        return cache[index][prevIndex];

    }
 
}