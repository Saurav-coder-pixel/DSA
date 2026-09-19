class Solution {
    boolean res= true;

    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        boolean[] vis= new boolean[n];
        boolean[] color= new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i]== false){
                dfs(graph, i, false, color, vis);
            }
        }

        return res;
    }

    private void dfs(int[][] graph, int node, boolean c, boolean[] color, boolean[] vis){
        color[node]= c;
        vis[node]= true;

        for(int i=0; i<graph[node].length; i++){
            int neigh= graph[node][i];

            if(vis[neigh] == false){
                dfs(graph, neigh, !c , color, vis);
            }else if(color[neigh]== color[node]){
                res= false;
            }
        }
    }
}
