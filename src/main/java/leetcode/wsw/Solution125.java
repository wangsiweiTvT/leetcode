package leetcode.wsw;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution125 {

    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            //           0-9 之间                      或者
            while (!((s.charAt(i) <= '9' && s.charAt(i) >= '0') ||
                    //a-z之间                          或者
                    (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') ||
                    //A-Z之间
                    (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A'))) {


                i++;
                if (i>=s.length()) return true;
            }
            while (!((s.charAt(j) <= '9' && s.charAt(j) >= '0') ||
                    //a-z之间                          或者
                    (s.charAt(j) <= 'z' && s.charAt(j) >= 'a') ||
                    //A-Z之间
                    (s.charAt(j) <= 'Z' && s.charAt(j) >= 'A'))) {
                j--;
                if (j<0) return true;

            }

            char p = s.charAt(i);
            char q = s.charAt(j);
            if (p <= 'Z' && p >= 'A') p = (char) (p + 32);
            if (q <= 'Z' && q >= 'A') q = (char) (q + 32);
            if (q != p) return false;

            i++;
            j--;
        }

        return true;

    }

}
