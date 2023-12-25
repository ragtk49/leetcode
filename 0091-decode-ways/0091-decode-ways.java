class Solution {
    HashMap<Integer, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap();
        return parseSubs(s, 0);
    }
    
    private int parseSubs(String s, int index){
        if(map.containsKey(index)){
            return map.get(index);
        }
         if(index == s.length()){
            return 1;
        }
         if(s.charAt(index) == '0'){
            return 0;
        }
        if(index == s.length()-1){
            return 1;
        }
        int count = parseSubs(s, index+1);
        if(Integer.parseInt(s.substring(index, index + 2)) <= 26){
            count = count + parseSubs(s, index + 2);
        }
        
        map.put(index, count);
        
        return count;
    }
}