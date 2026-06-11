class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> mp= new HashMap<>();
        int res=0;
        boolean hasOdd= false;

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)+ 1);
            }else{
                mp.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: mp.entrySet()){
            int val= entry.getValue();
            if(val%2 == 0){
                res += val;
            }
            else if(val%2 == 1){
                res += val-1;
                hasOdd= true;
            }
        }

        return hasOdd ? res+1 : res;
    }
}
