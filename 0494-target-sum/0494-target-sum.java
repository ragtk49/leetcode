class Solution {
    int[] nums;
    int count;
    int target;
    int[][] cache;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        total = Arrays.stream(nums).sum();
        cache = new int[nums.length + 1][2 * total+1];
        
        if(nums == null) return 0;
        return helper(0, 0);
    }
    private int helper(int index, int sum){
        //base
        if(index == nums.length){
           return  (sum == target) ? 1 : 0;
        }
        
        if(cache[index][sum + total] != 0) return cache[index][sum + total]; 
        
        //logic
        int add = helper(index + 1, sum + nums[index]);
        int delete = helper(index + 1, sum - nums[index]);
        
        cache[index][sum + total] = add + delete;
        
        return cache[index][sum + total];
    }
}