class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mp= new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)+1);
            }else{
                mp.put(c, 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(mp.get(s.charAt(i))== 1){
                return i;
            }
        }

        return -1;
    }
}
