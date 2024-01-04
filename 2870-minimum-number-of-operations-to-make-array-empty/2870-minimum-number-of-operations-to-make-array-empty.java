class Solution {
    public int minOperations(int[] nums) {
        if(nums == null) return -1;
        int ops = 0;
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0) + 1);    
        }
        
        for(int num : map.values()){
            if(num == 1){
                return -1;
            }
            if (num % 3 == 1) {
                ops += (num / 3) - 1;
                ops += 2;
            } else {
                ops += (num/ 3);
                ops += ((num % 3) / 2);
            }
        }
        return ops;
    }
}