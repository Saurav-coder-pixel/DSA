class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int MaxEnding= nums[0];
        int MinEnding= nums[0];
        int res= nums[0];

        for(int i=1; i<n; i++){
            int n1= MaxEnding* nums[i];
            int n2= MinEnding* nums[i];
            int n3= nums[i];
            MaxEnding= Math.max(n3, Math.max(n1, n2));
            MinEnding= Math.min(n3, Math.min(n1, n2));
            res= Math.max(MaxEnding, res);
        }

        return res;
    }
}
