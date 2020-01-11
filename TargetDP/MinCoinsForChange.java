package TargetDP;

public class MinCoinsForChange {
    private static int coinChange(int[] coins, int amount) {
        int[] memoization = new int[amount+1];
        memoization[0]=0;
        for(int i=1;i<=amount;i++){
            int min = -1;
            for(int j=0;j<coins.length;j++){
                int temp = 0;
                if(i-coins[j]>=0) {
                    temp = memoization[i-coins[j]];
                    if(temp!=-1 && min==-1) min=temp;
                    else if(temp!=-1 && min!=-1) min=Math.min(min,temp);
                }
            }
            if(min==-1) memoization[i]=-1;
            else memoization[i]=1+min;
        }
        return memoization[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5,11};
        int amount = 17;
        int result = coinChange(coins,amount);
        System.out.println(result);
    }
}
