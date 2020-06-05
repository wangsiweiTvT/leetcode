package leetcode.wsw;

public class Solution198 {

    public static void main(String[] args) {
    }

    public int rob(int[] nums) {
        if (nums==null) return 0;
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int q=0;
        int p=nums[0];
        int r=0;
        int i=1;
        while (i<nums.length){

            r=Math.max(p,q+nums[i++]);
            q=p;
            p=r;

        }

        return r;


    }




}
