package leetcode.wsw;

public class Solution238 {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        result[0]=1;
        result[nums.length-1]=1;
        //int left=nums[0],right=nums[nums.length-1];
        int mark;
        int i=1;
        int j;
        while (i<nums.length){

            j=nums.length-1-i;

            if (i>=nums.length/2){
                if (i==j){

                    i++;
                    continue;
                }else {
                    nums[i]=result[i+1]*nums[i-1];
                    nums[j]=nums[j+1]*nums[j-1];
                }

            }else {
                result[i]=result[i-1]*nums[i];
                result[j]=result[j+1]*nums[j];
            }
            i++;
        }


        return result;
    }

}
