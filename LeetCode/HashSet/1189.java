class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> mp= new HashMap<>();
        HashMap<Character, Integer> mp1= new HashMap<>();

        for(int i=0; i< text.length(); i++){
            char ch= text.charAt(i);

            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch)+1);
            }else{
                mp.put(ch, 1);
            }
        }

        int b= mp.getOrDefault('b',0)/1;
        int a= mp.getOrDefault('a',0)/1;
        int l= mp.getOrDefault('l',0)/2;
        int o= mp.getOrDefault('o',0)/2;
        int n= mp.getOrDefault('n',0)/1;

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
