class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l= new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        fun(candidates, target, 0, 0, l, temp);
        return l;
    }

    private void fun(int[] candidates, int target, int idx, int sum, List<List<Integer>> l, List<Integer> temp){
        if(sum== target){
            l.add(new ArrayList<>(temp));
            return;
        }

        if(idx== candidates.length || sum> target){
            return;
        }

        //Choose the idx
        temp.add(candidates[idx]);
        fun(candidates, target, idx, sum + candidates[idx], l, temp);
        temp.remove(temp.size()-1);

        //Don't Choose the idx
        fun(candidates, target, idx + 1, sum, l, temp);
    }
}
