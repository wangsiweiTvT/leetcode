package leetcode.wsw;

/**
 * @Auther: wangsiwei
 * @Date: 2023/2/3 16:13
 * @Description:
 * 剑指 Offer 51. 数组中的逆序对
 *
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 归并排序 过程
 */
public class Offer51 {

    public int reversePairs(int[] nums) {

        if (nums.length<=1) return 0;

        return process(nums,0,nums.length-1);
    }

    public static int process(int[] nums,int l ,int r){
        if (l==r) return 0;
        int mid=l+((r-l)>>1);
        return process(nums,l,mid)+process(nums,mid+1,r)+merge(nums,l,mid,r);
    }

    public static int merge(int[] nums,int l ,int mid,int r){
        int[] help = new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        int num=0;
        while (p1<=mid&&p2<=r){
            if(nums[p1]<=nums[p2])help[i++]=nums[p1++];
            else {
                num+=(mid-p1+1);
                help[i++]=nums[p2++];
            }
        }

        while (p1<=mid){
            help[i++]=nums[p1++];
        }
        while (p2<=r){
            help[i++]=nums[p2++];
        }



        for (int j = 0; j <= help.length-1 ; j++) {
            nums[l++]= help[j];
        }

        return num;

    }
}
