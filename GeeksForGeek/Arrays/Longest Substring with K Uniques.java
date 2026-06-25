class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int low= 0;
        int high= 0;
        int res= -1;
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        
        for(high=0 ; high<n; high++){
            char ch= s.charAt(high);
            
            // if(mp.containsKey(ch)){
            //     mp.put(ch, mp.get(ch)+ 1);
            // }else{
            //     mp.put(ch, 1);
            // }
            
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            
            while(mp.size()> k){
                char ch1= s.charAt(low);
                
                mp.put(ch1, mp.get(ch1)-1);
                
                if(mp.get(ch1)== 0){
                    mp.remove(ch1);
                }
                low++;
            }
            
            if(mp.size()== k){
                int len= high - low + 1;
                res= Math.max(len, res);
            }
        }
        
        return res;
    }
}
