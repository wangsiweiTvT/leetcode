package leetcode.wsw;

import java.util.ArrayList;
import java.util.List;

public class Solution1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue=0;
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int i=0;i<candies.length;i++) maxValue=Math.max(maxValue,candies[i]);
        for (int i=0;i<candies.length;i++) booleans.add(candies[i]>=maxValue-extraCandies);
        return booleans;
    }

}
