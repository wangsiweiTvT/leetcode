package leetcode.wsw;

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

import java.util.HashMap;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        new Solution1().twoSum(nums,9);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intMap = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (intMap.containsKey(target-nums[i])) {
                int[] ints = new int[2];
                ints[0]=i;
                ints[1]=intMap.get(target-nums[i]);
                return ints;
            }
            intMap.put(nums[i],i);
        }
        return null;
    }

}
