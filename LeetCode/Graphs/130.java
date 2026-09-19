class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;

        for(int j=0; j<n; j++){
            if(board[0][j]== 'O'){
                dfs(board, 0, j, m, n);
            }
        }

        for(int j=0; j<n; j++){
            if(board[m-1][j]== 'O'){
                dfs(board, m-1, j, m, n);
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][0]== 'O'){
                dfs(board, i, 0, m, n);
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][n-1]== 'O'){
                dfs(board, i, n-1, m, n);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]== '#'){
                    board[i][j]= 'O';
                }else{
                    board[i][j]= 'X';
                }
            }
        }
    }

    private boolean valid(int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        return true;
    }

    int[] x= {-1,1,0,0};
    int[] y= {0,0,-1,1};

    private void dfs(char[][] board, int i, int j, int m, int n){
        board[i][j]= '#';

        for(int k=0; k<4; k++){
            int row= i+ x[k];
            int col= j+ y[k];

            if(valid(row, col, m, n) && board[row][col]== 'O'){
                dfs(board, row, col, m, n);
            }
        }
    }
}
