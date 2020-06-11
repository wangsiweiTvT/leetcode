package leetcode.wsw;


/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution739 {

    public static void main(String[] args) {
        int[] arg={73,74,75,71,69,72,76,73};

        new Solution739().dailyTemperatures(arg);
    }

    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        if (T.length == 1) return results;
        c:
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i;
            if (T[j + 1] > T[j]) {
                results[i] = 1;
                continue;
            }
            j++;
            while (T[j] <= T[i]) {

                if (results[j] == 0) {
                    results[i] = 0;
                    continue c;
                }
                j += results[j];
            }
            results[i]=j-i;
        }
        return results;
    }


}
