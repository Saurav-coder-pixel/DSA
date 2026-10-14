class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int[] res= new int[n];
        int left= 0;
        int right= n-1;
        int pos= n-1;

        while(left<= right){
            int leftSqr= nums[left]* nums[left];
            int rightSqr= nums[right]* nums[right];

            if(leftSqr> rightSqr){
                res[pos--]= leftSqr;
                left++;
            }else{
                res[pos--]= rightSqr;
                right--;
            }
        }

        return res;
    }
}
