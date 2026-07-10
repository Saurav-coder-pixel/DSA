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




//Through min Heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], 1);
            }else{
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
        }

        class Pair{
            int first;
            int second;
            Pair(int f, int s){
                first= f;
                second= s;
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a,b)-> {
                if(a.first!= b.first){
                    return a.first - b.first;
                }
                return a.second- b.second;
            }
        );

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(pq.size()< k){
                pq.offer(new Pair(entry.getValue(), entry.getKey()));
            }else if(entry.getValue() > pq.peek().first){
                pq.poll();
                pq.offer(new Pair(entry.getValue(), entry.getKey()));
            }
        }

        int res[]= new int[k];
        for(int i=0 ; i<k; i++){
            res[i] = pq.poll().second;
        }

        return res;
    }
}
