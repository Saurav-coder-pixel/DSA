class Solution {
    HashMap<Integer, Integer> dp= new HashMap<>();
    
    public int tribonacci(int n) {
        if(n== 0) return 0;
        if(n== 1 || n== 2) return 1;

        if(dp.containsKey(n)) return dp.get(n);;

        int ans= tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        dp.put(n, ans);

        return ans;
    }
}
