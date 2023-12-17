class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs == null) return res;
        
        HashMap<String, List<String>> map = new HashMap();
        
        for(int i = 0; i < strs.length; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(strs[i]);
        }
        
        for(List<String> string : map.values()){
            res.add(string);
        }
        
        return res;
    }
}