class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> l= new ArrayList<>();
        int[] indegree= new int[V];
        Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> res= new ArrayList<>();
        
        for(int i=0; i<V; i++){
            l.add(new ArrayList());
        }
        
        for(int i=0; i<edges.length; i++){
            int src= edges[i][0];
            int dest= edges[i][1];
            
            l.get(src).add(dest);
            indegree[dest] += 1;
        }
        
        for(int i=0; i<V; i++){
            if(indegree[i]== 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node= q.poll();
            res.add(node);
            
            for(int i=0; i<l.get(node).size(); i++){
                int neigh= l.get(node).get(i);
                indegree[neigh]--;
                
                if(indegree[neigh]== 0){
                    q.add(neigh);
                }
            }
        }
        
        return res;
    }
}