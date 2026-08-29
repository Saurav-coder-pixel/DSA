class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l= new ArrayList<>(); 
        List<Integer> temp= new ArrayList<>();

        fun(nums, 0, l, temp);
        return l;
    }

    private void fun(int[] nums, int idx, List<List<Integer>> l, List<Integer> temp){
        if(temp.size()== nums.length){
            l.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            
            temp.add(nums[i]);
            fun(nums, idx+1, l, temp);
            temp.remove(temp.size()-1);
        }
    }
}
