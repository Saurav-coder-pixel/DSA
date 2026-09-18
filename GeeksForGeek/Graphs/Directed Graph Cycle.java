class Solution {
    boolean cycle= false;
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> l= new ArrayList<>();
        boolean[] vis= new boolean[V];
        boolean[] path= new boolean[V];
        
        for(int i=0; i<V; i++){
            l.add(new ArrayList());
        }
        
        for(int i=0; i<edges.length; i++){
            int src= edges[i][0];
            int dest= edges[i][1];
            
            l.get(src).add(dest);
        }
        
        for(int i=0; i<V; i++){
            if(vis[i]== false){
                dfs(l, i, vis, path);
            }
        }
        
        return cycle;
        
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> l, int node, boolean[] vis, boolean[] path){
        vis[node]= true;
        path[node]= true;
        
        for(int i=0; i<l.get(node).size(); i++){
            int neigh= l.get(node).get(i);
            
            if(vis[neigh]== true && path[neigh]== true){
                cycle= true;
            }
            if(vis[neigh]== false){
                dfs(l, neigh, vis, path);
            }
        }
        
        path[node]= false;
    }
}
