package leetcode.wsw;

import sun.swing.plaf.synth.DefaultSynthStyle;

import java.util.List;

/**
 *
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 *
 */
public class M0806hanota {


    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        process(A.size(),A,B,C);

    }

    public static void process(int n,List<Integer> from, List<Integer> other, List<Integer> to){

        if (n==1){
            to.add(from.get(from.size()-1));
            from.remove(from.size()-1);
            return;
        }

        process(n-1,from,to,other);
        process(1,from,other,to);
        process(n-1,other,from,to);




    }


}
