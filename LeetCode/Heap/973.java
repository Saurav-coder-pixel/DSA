class Solution {
    public int[][] kClosest(int[][] points, int k) {

        class Pair{
            int dist;
            int[] point;

            Pair(int d, int[] p){
                dist= d;
                point= p;
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a,b)->{
                if(a.dist != b.dist){
                    return b.dist - a.dist;
                }
                return 0;
            }
        );

        for(int i=0; i<points.length; i++){
            int d= distance(points[i][0], points[i][1]);
            Pair p = new Pair(d, points[i]);

            if(pq.size()< k){
                pq.offer(p);
            }
            else if(pq.peek().dist > d){
                pq.poll();
                pq.offer(p);
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            result[i] = p.point;
        }

        return result;
    }

    private int distance(int x, int y){
        return (x*x + y*y);
    }
}
