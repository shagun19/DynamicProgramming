package TargetDP;

public class MinPathFallCost {
    public static int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int[][] memoization = new int[A.length][A.length];
        for(int i=0;i<A[0].length;i++) {
            memoization[0][i]=A[0][i];
            if(A.length==1) min=Math.min(min,memoization[0][i]);
        }
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(true){
                    if (j==0) memoization[i][j]=Math.min(memoization[i-1][j],memoization[i-1][j+1]);
                    else if (j==A.length-1) memoization[i][j]=Math.min(memoization[i-1][j],memoization[i-1][j-1]);
                    else memoization[i][j]=Math.min(memoization[i-1][j],Math.min(memoization[i-1][j-1],memoization[i-1][j+1]));
                    memoization[i][j]=A[i][j]+memoization[i][j];
                    if(i==A.length-1) min=Math.min(memoization[i][j],min);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int res = minFallingPathSum(A);
        System.out.println(res);
    }
}
