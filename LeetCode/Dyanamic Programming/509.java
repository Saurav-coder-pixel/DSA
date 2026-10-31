class Solution {
    public int fib(int n) {
        if(n<= 1) return n;

        // int[] dp= new int[n+1];
        // dp[0]= 0;
        // dp[1]= 1;
        int prev2= 0;
        int prev1= 1;

        for(int i=2; i<=n; i++){
            //dp[i]= dp[i-1] + dp[i-2];
            int ans= prev1 + prev2;
            prev2= prev1;
            prev1= ans;
        }

        return prev1; //return dp[n];
    }
}
