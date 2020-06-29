package leetcode.wsw;


import java.util.Arrays;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution209 {


    public static void main(String[] args) {

        //7
        //[2,3,1,2,4,3]
        int[] ints={1,2,3,4,5};

//        int[] test={1,2,3,4,5,7};
//        System.out.println(~Arrays.binarySearch(test,8));

        new Solution209().minSubArrayLen2(11,ints);

    }

    /**
     * 滑动窗口方法 时间复杂度O(n)
     *
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0) return 0;
        int result=Integer.MAX_VALUE;
        int p=0,q=0;
        int sum=nums[0];
        do{
            if (p==nums.length) break;
            int len=p-q+1;
            if (sum>=s){
                result=Math.min(len,result);
                sum=sum-nums[q++];
            }
            else {
                ++p;
                if (p==nums.length) break;
                sum+=nums[p];
            }

        }while (q<=p);
        return result==Integer.MAX_VALUE?0:result;

    }

    /**
     * 二分法 时间复杂度O(nlogn)
     *
     * sums[k]-sums[j]>=s
     * sums[j]+s<=sums[k]
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length==0) return 0;
        int[] sums = new int[nums.length + 1];
        sums[1]=nums[0];
        for (int i=1;i<=nums.length-1;i++) sums[i+1]=sums[i]+nums[i];
        if (sums[sums.length-1]<s) return 0;
        int result=Integer.MAX_VALUE;
        for (int i=1;i<sums.length-1;i++){
            int search = Arrays.binarySearch(sums, sums[i] + s);
            if (search<0) {
                if (~search==sums.length) continue;
                result=Math.min(result,(~search)-i);
            }
            else  result=Math.min(result,search-i);
        }
        return result;
    }

}
