class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int prov= 0;
        boolean[] vis= new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i]== false){
                dfs(isConnected, i, vis);
                prov++;
            }
        }

        return prov;
    }


    private void dfs(int[][] isConnected, int i, boolean[] vis){
        vis[i]= true;

        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j]== 1 && vis[j]== false){
                dfs(isConnected, j, vis);
            }
        }
    }
}
