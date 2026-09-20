class Solution {
    class Pair{
        int first;
        int second;
        
        Pair(int a, int b){
            this.first= a;
            this.second= b;
        }
    }
    
    public int shortestPath(int V, int[][] edges, int src, int dest) {
      ArrayList<ArrayList<Integer>> l= new ArrayList<>();
      Queue<Pair> q= new LinkedList<>();
      int[] res= new int[V];
      boolean[] vis= new boolean[V];
      
      for(int i=0; i<V; i++){
          l.add(new ArrayList<>());
      }
      
      for(int i=0; i<edges.length; i++){
          int u= edges[i][0];
          int v= edges[i][1];
          
          l.get(u).add(v);
          l.get(v).add(u);
      }
      
      q.add(new Pair(src, 0));
      vis[src]= true;
      
      while(!q.isEmpty()){
          Pair p= q.poll();
          
          int node= p.first;
          int dist= p.second;
          res[node]= dist;
          
          if(node== dest) return dist;
          
          for(int i=0; i<l.get(node).size(); i++){
              int neigh= l.get(node).get(i);
              
              if(vis[neigh]== false){
                  q.add(new Pair(neigh, dist+1));
                  vis[neigh]= true;
              }
          }
      }
      
      return -1;
    }
    
}
