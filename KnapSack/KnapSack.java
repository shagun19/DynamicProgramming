package KnapSack;

public class KnapSack {
    private static int getMaxValue(int W, int[][] items){
        int[][] memoization = new int[items.length][W+1];
        for(int i=0;i<items.length;i++){
            for(int j=0;j<=W;j++){
                int weight = items[i][0];
                int value = items[i][1];
                if(i==0|| j==0) memoization[i][j]=0;
                else if(weight<=j) memoization[i][j]=Math.max(value+memoization[i-1][j-weight],memoization[i-1][j]);
                else memoization[i][j]=memoization[i-1][j];
            }
        }
        return memoization[items.length-1][W];
    }
    public static void main(String[] args) {
        int[] itemValues = { 0,20, 5, 10, 40, 15, 25 };
        int[] itemWeights = { 0,1, 2, 3, 8, 7, 4 };
        int W = 10;
        int[][] items = new int[itemValues.length][2];
        for(int i=0;i<itemValues.length;i++){
            items[i][0]=itemWeights[i];
            items[i][1]=itemValues[i];
        }
        int result = getMaxValue(W,items);
        System.out.println(result);
    }
}