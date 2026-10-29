class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n= val.length;
        int[][] dp= new int[n][W+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=W; j++){
                dp[i][j]= -1;
            }
        }
        
        return fun(0,n,val,wt,W,dp);
    }
    
    private int fun(int i, int n, int val[], int wt[], int W, int dp[][]){
        if(i== n){
            return 0;
        }
        
        if(dp[i][W] != -1) return dp[i][W];
        
        if(wt[i]> W){
            return dp[i][W]= fun(i+1, n, val, wt, W, dp);
        }
        
        int yes= val[i] + fun(i+1, n, val, wt, W-wt[i], dp);
        int no= fun(i+1, n, val, wt, W, dp);
        
        return dp[i][W]= Math.max(yes, no);
    }
}
