class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int left= 0;
        int right= k;
        int sum= 0;
        int n= arr.length;
        
        for(int i=0; i<right; i++){
            sum= sum + arr[i];
        }
        
        int maxSum= sum;
        
        while(right< n){
            sum= sum + arr[right]- arr[left];
            maxSum= Math.max(maxSum, sum);
            left++;
            right++;
        }
        
        return maxSum;
    }
}