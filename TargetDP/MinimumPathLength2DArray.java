package TargetDP;

public class MinimumPathLength2DArray {
    private static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] memoization = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0) memoization[i][j]=grid[i][j];
                else if(i == 0) memoization[i][j]=grid[i][j]+memoization[i][j-1];
                else if(j == 0) memoization[i][j]=grid[i][j]+memoization[i-1][j];
                else memoization[i][j]=grid[i][j]+Math.min(memoization[i][j-1],memoization[i-1][j]);
            }
        }
        return memoization[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }
}
