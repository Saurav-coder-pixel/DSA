class Solution {
    public int totalFruit(int[] fruits) {
        int low=0;
        int high=0;
        int maxFruit= 0;
        int n= fruits.length;
        HashMap<Integer, Integer> mp= new HashMap<>();

        for(high= 0; high<n; high++){
            mp.put(fruits[high], mp.getOrDefault(fruits[high], 0) +1);

            while(mp.size()> 2){
                mp.put(fruits[low], mp.getOrDefault(fruits[low], 0) -1);

                if(mp.get(fruits[low])== 0){
                    mp.remove(fruits[low]);
                }
                low++;
            }

            // if(mp.size()== 2 || mp.size()< 2){
            //     int len= high- low + 1;
            //     maxFruit= Math.max(len, maxFruit);
            // }

            int len= high- low + 1;
            maxFruit= Math.max(len, maxFruit);
        }
        return maxFruit;
    }
}
