class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> l= new LinkedList<>();

        int r= matrix.length;
        int c= matrix[0].length;
        int totalElement=0;

        int topRow=0, bottomRow=r-1, leftCol=0, rightCol=c-1;
        
        while(topRow <= bottomRow && leftCol <= rightCol){
            for(int j= leftCol; j<= rightCol; j++){
                l.add(matrix[topRow][j]);
                totalElement++;
            }
            topRow++;

            for(int i= topRow; i<= bottomRow; i++){
                l.add(matrix[i][rightCol]);
                totalElement++;
            }
            rightCol--;

            if(topRow<=bottomRow){
                for(int j= rightCol; j>= leftCol; j--){
                    l.add(matrix[bottomRow][j]);
                    totalElement++;
                }
                bottomRow--;
            }

            if(leftCol<= rightCol){
                for(int i= bottomRow; i>= topRow; i--){
                    l.add(matrix[i][leftCol]);
                    totalElement++;
                }
                leftCol++;
            }
        }
        return l;
    }
}
