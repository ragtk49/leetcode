class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        int cookieIndex = 0;
        
        while(childIndex < g.length && cookieIndex < s.length){
            if(s[cookieIndex] >= g[childIndex]){
                childIndex++;
            }
            cookieIndex++;
        }
        return childIndex;
    }
}