class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int count = -1;
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                count = Math.max(count, i - map.get(s.charAt(i)) - 1);
            }
            else{
                map.put(s.charAt(i), i);
            }
        }
        return count;
    }
}