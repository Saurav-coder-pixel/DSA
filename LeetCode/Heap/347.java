class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], 1);
            }else{
                mp.put(nums[i], mp.get(nums[i])+ 1);
            }
        }

        List<Integer> keys = new ArrayList<>(mp.keySet());
        keys.sort((a,b) -> mp.get(b)- mp.get(a));

        int[] res= new int[k];
        for(int i=0; i<k; i++){
            res[i]= keys.get(i);
        }

        return res;
    }
}
