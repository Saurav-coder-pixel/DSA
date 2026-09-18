class Solution {
    boolean cycle= false;
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int n= edges.length;
        ArrayList<ArrayList<Integer>> a= new ArrayList<>();
        boolean[] vis= new boolean[V];
        
        for (int i = 0; i < V; i++) {
            a.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            int src= edges[i][0];
            int dest= edges[i][1];
            a.get(src).add(dest);
            a.get(dest).add(src);
        }
        
        for(int i=0; i<V; i++){
            if(vis[i]== false){
                dfs(a, i, -1, vis);
            }
        }
        
        return cycle;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> a, int node, int parent, boolean[] vis){
        vis[node]= true;
        
        for(int i=0; i<a.get(node).size(); i++){
            int neigh= a.get(node).get(i);
            
            if(vis[neigh]== false){
                dfs(a, neigh, node, vis);
            }
            else if(neigh!= parent){
                cycle= true;
            }
        }
    }
}
