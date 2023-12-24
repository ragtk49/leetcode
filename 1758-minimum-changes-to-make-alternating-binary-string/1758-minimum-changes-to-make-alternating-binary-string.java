class Solution {
    public int minOperations(String s) {
        int count0 = 0;
        for(int i = 0; i < s.length(); i++){
            if(i%2 == 0){
                if(s.charAt(i) == '1'){
                    count0++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    count0++;
                }
            }
        }
        return Math.min(count0, s.length() - count0);
        
    }
}