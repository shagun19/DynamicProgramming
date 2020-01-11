package TargetDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinCostTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int maxDays = days[days.length-1];
        HashSet<Integer> daysSet = new HashSet<>();
        for(int x: days) daysSet.add(x);
        int[] memoization = new int[maxDays+1];
        memoization[0]=0;
        for(int i=1;i<=maxDays;i++){
            if(daysSet.contains(i)){
                List<Integer> temp = new ArrayList<>();
                temp.add(costs[0]+memoization[i-1]);
                if(i-7>=0) temp.add(costs[1]+memoization[i-7]);
                else temp.add(costs[1]);
                if(i-30>=0) temp.add(costs[2]+memoization[i-30]);
                else temp.add(costs[2]);
                Collections.sort(temp);
                memoization[i]=temp.get(0);
            }
            else memoization[i]=memoization[i-1];
        }
        return memoization[maxDays];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int res = mincostTickets(days,costs);
        System.out.println(res);
    }
}
