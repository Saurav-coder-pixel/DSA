// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> q = new PriorityQueue<>();

//         for(int num: nums){
//             q.offer(num);
//             if(q.size()> k){
//                 q.poll();
//             }
//         }
//         return q.peek();
//     }
// }


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            if(pq.peek()< nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}
