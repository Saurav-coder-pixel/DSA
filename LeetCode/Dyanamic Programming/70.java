class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        return solve(0, n);
    }

    private int solve(int i, int n){
        if(i== n) return 1;
        if(i> n) return 0;

        if(dp.containsKey(i)) return dp.get(i);

        int ans= solve(i+1, n) + solve(i+2, n);
        dp.put(i, ans);

        return ans;
    }
}