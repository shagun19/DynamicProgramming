package TargetDP;

public class MinCostStairs {
    private static int minCostClimbingStairs(int[] cost) {
        int[] memoization = new int[cost.length+1];
        memoization[0]=cost[0];
        memoization[1]=cost[1];
        for(int i=2;i<=cost.length;i++){
            if(i!=cost.length) memoization[i]=cost[i]+ Math.min(memoization[i - 1], memoization[i - 2]);
            else memoization[i]= Math.min(memoization[i - 1], memoization[i - 2]);
        }
        return memoization[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
