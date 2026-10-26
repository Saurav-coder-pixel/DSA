class Solution {
    public int rob(int[] nums) {
        int n= nums.length; 
        int[][] dp= new int[n][2];
        
        for(int i=0; i<n; i++){
            dp[i][0]= -1;
            dp[i][1]= -1;
        }

        return fun(nums,0,1,dp); 
    }

    private int fun(int[] nums, int i, int free, int[][] dp){
        int n= nums.length;

        if(i== n) return 0;

        if(dp[i][free] != -1){
            return dp[i][free];
        }

        if(free== 0){
            return dp[i][free]= fun(nums, i+1, 1, dp);
        }

        int a1= nums[i] + fun(nums, i+1, 0, dp);
        int a2= fun(nums, i+1, 1, dp);

        return dp[i][free]= Math.max(a1,a2);
    }
}
