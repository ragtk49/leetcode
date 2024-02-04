class Solution {
    public String minWindow(String s, String t) {
                //define table
        int[] arr = new int[128];

        //base case 
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        //define pointers
        int L = 0, R = 0;
        int counter = 0;
        int minLen = Integer.MAX_VALUE;;

        //increment the t in arr
        for(char curr : t_arr){
            arr[curr]++;
        }

        //define ans
        String ans = "";

        //find the min window
        while(R < s_arr.length){
            //expand the window
            char currChar = s_arr[R];
            if(--arr[currChar] >= 0){
                counter++;
            }

            //shrink window when coondition met
            while(counter == t_arr.length){
                int curWindow = R - L + 1;
                if(curWindow < minLen){
                    minLen = curWindow;
                    ans = s.substring(L, R+1);
                }
                //shrink the window
                char leftChar = s_arr[L];
                if(++arr[leftChar] > 0){
                    counter--;
                }
                L++;
            }
            //increment R
            R++;
        }
        //return ans
        return ans;
    }
}