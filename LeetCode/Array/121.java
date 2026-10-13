class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int MaxProfit=0;
        int minPrice= Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(prices[i]< minPrice){
                minPrice= prices[i];
            }else{
                int profit= prices[i]- minPrice;
                MaxProfit= Math.max(MaxProfit, profit);
            }
        }
        return MaxProfit;
    }
}









class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int min= Integer.MAX_VALUE;
        int MaxProfit= 0;

        for(int i=0; i<n; i++){
            min= Math.min(min, prices[i]);
            int profit= prices[i] - min;
            MaxProfit= Math.max(profit, MaxProfit);
        }

        return MaxProfit;
    }
}
