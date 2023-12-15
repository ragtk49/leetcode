class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap();
        
        int left = 0;
        int right = 0;
        
        while(right < n){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r,0) + 1);
            
            while(map.get(r) > 1){
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l,0) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    
  
}