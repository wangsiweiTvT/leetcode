package leetcode.wsw;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class O46 {

    public int translateNum(int num) {

        String s = String.valueOf(num);
        return possibleTrans(s.toCharArray(),0);
    }

    public int possibleTrans(char[] num,int pos){
        if (pos>=num.length-1) return 1;
        if (num[pos]>='3'||num[pos]=='0'){
            return possibleTrans(num, pos+1);
        }

        if (num[pos]=='1') return possibleTrans(num, pos+2)+possibleTrans(num, pos+1);
        return num[pos+1]>='6'? possibleTrans(num, pos+1):possibleTrans(num, pos+2)+possibleTrans(num, pos+1);
    }





}
