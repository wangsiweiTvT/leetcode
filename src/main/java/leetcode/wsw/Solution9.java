package leetcode.wsw;

/**
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9 {


    public static void main(String[] args) {

        String s = String.valueOf(-100);
        System.out.println(s);
        boolean palindrome = new Solution9().isPalindrome(1);
        System.out.println(palindrome);

    }

    public boolean isPalindrome(int x) {


        String s = String.valueOf(x);
        int i=0;
        int j=s.length()-1;
        while (i<=j) if (s.charAt(i++)!=s.charAt(j--)) return false;
        return true;


    }


}
