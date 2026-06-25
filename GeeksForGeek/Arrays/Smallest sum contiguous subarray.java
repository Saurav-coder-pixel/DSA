class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int bestEnding = a[0];
        int res= a[0];
        
        for(int i=1; i<size; i++){
            int n1= bestEnding+ a[i];
            int n2= a[i];
            bestEnding= Math.min(n1, n2);
            res= Math.min(bestEnding, res);
        }
        
        return res;
    }
}
