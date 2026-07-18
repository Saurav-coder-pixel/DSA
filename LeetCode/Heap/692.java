class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<words.length; i++){
            if(!mp.containsKey(words[i])){
                mp.put(words[i], 1);
            }else{
                mp.put(words[i], mp.get(words[i])+1);
            }
        }

        class Pair{
            String first;
            int second;

            Pair(String f, int s){
                first = f;
                second = s;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.second != b.second){
                    return a.second- b.second;
                }
                return b.first.compareTo(a.first);
            }
        );

        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            Pair p= new Pair(entry.getKey(), entry.getValue());
            if(pq.size()< k){
                pq.offer(p);
            }else if(pq.comparator().compare(p, pq.peek()) > 0){
                pq.poll();
                pq.offer(p);
            }
        }

        LinkedList<String> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.addFirst(pq.poll().first);
        }

        return list;
    }
}
