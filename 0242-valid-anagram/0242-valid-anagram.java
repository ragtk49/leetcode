class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap();
        
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++){
            sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        for(int value : sMap.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }
}