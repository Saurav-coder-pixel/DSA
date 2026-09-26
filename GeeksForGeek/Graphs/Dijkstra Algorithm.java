class Solution {
    class Pair{
        int first;
        int second;
        
        Pair(int a, int b){
            this.first= a;
            this.second= b;
        }
    }
    
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> l= new ArrayList<>();
        
        for(int i=0; i<V; i++){
            l.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int sr= edges[i][0];
            int dest= edges[i][1];
            int wgh= edges[i][2];
            
            l.get(sr).add(new Pair(dest, wgh));
            l.get(dest).add(new Pair(sr, wgh));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.first-b.first
        );
        
        ArrayList<Integer> dist= new ArrayList<>();
        
        for(int i=0; i<V; i++){
            dist.add(Integer.MAX_VALUE);
        }
        
        dist.set(src, 0);
        pq.add(new Pair(0, src));
        
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            
            int d= p.first;
            int node= p.second;
            
            if(d> dist.get(node)){
                continue;
            }
            
            for(int i=0; i<l.get(node).size(); i++){
                int neigh= l.get(node).get(i).first;
                int wt= l.get(node).get(i).second;
                
                if(d+wt < dist.get(neigh)){
                    dist.set(neigh, d+wt);
                    pq.add(new Pair(d+wt, neigh));
                }
            }
        }
        
        return dist;
    }
}
