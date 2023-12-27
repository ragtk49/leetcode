class Solution {
    public int maxProduct(int[] nums) {
        int take = nums[0];
        int skip = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If the current element is negative, take and skip will swap
            if (nums[i] < 0) {
                int temp = take;
                take = skip;
                skip = temp;
            }

            // Update take and skip values
            take = Math.max(nums[i], take * nums[i]);
            skip = Math.min(nums[i], skip * nums[i]);

            // Update the result
            maxProduct = Math.max(maxProduct, take);
        }

        return maxProduct;
    }
}