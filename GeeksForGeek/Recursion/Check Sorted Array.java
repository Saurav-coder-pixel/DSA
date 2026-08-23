class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        return helper(arr, 0);
    }
    
    private boolean helper(int[] arr, int i){
        int n= arr.length;
        
        if(i >= n-1){
            return true;
        }
        
        if(arr[i+1] < arr[i]){
            return false;
        }
        
        boolean ans= helper(arr, i+1);
        
        return ans;
    }
}
