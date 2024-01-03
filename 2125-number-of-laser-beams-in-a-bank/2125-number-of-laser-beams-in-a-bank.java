class Solution {
    public int numberOfBeams(String[] bank) {
        if(bank == null) return 0;
        int prev = 0;
        int res = 0;
        
        for(String s : bank){
            int count  = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                }
            }
            if(count > 0){
                res = res + prev * count;
                prev = count;
            }
        }
        return res;
    }
}