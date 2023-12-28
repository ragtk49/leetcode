class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int getLengthOfOptimalCompression(String s, int k) {
        return helper(s, 0, k, ' ', 0);
    }
    private int helper(String s,int index, int k, char prev, int prevCount) {
        if(k < 0){
            return Integer.MAX_VALUE;
        }
        if(index == s.length()){
            return 0;
        }
        
        // Creating a unique key for memoization
        String key = index + "-" + k + "-" + prev + "-" + prevCount;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int res = 0;
        
        if(s.charAt(index) == prev){
            int increment = (prevCount == 1 || prevCount == 9 || prevCount == 99) ? 1 : 0;
            res = increment + helper(s, index + 1, k, s.charAt(index), prevCount + 1);
        }
        else{
            int deleteChar = helper(s, index + 1, k - 1, prev, prevCount);
            int keepChar = 1 + helper(s, index + 1, k, s.charAt(index), 1);
            res = Math.min(deleteChar, keepChar);
        }
        
        memo.put(key, res);
        return res;
    }
}