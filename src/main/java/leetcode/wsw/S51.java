package leetcode.wsw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wangsiwei
 * @Date: 2023/2/17 11:09
 * @Description:
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 *
 */
public class S51 {


    public static void main(String[] args) {
        solveNQueens(4);
    }


    public static List<List<String>> solveNQueens(int n) {

        ArrayList<List<String>> result = new ArrayList<>();

        if (n==1){
            ArrayList<String> q1 = new ArrayList<>();
            q1.add("Q");
            result.add(q1);
            return result;
        }
        int[] record = new int[n];

        String[] preResult=new String[n];
        process(0,record,preResult,result,n);

        return result;
    }

    public static void process(int pos,int[] record,String[] preResult,List<List<String>> result,int n){

        if (pos==n){
            result.add(Arrays.asList(preResult));
            return;
        }

        char[] chars = new char[n];


        for (int i = 0; i < n; i++) {
            if (canPutQ(record,i,pos)){
                int c=0;
                while (c<n){
                    if (c!=i){
                        chars[c]='.';
                    }else{
                        chars[c]='Q';
                    }
                    c++;
                }
                preResult[pos]=new String(chars);
                String[] preResultCopy = Arrays.copyOf(preResult, preResult.length);
                record[pos]=i;
                int[] copy = Arrays.copyOf(record, record.length);
                process(pos+1,copy,preResultCopy,result,n);
            }
        }
    }
    public static boolean canPutQ(int[] record,int j,int row){
        for (int i = 0; i <row; i++) {
            if (record[i]==j||Math.abs(row-i)==Math.abs(record[i]-j)) return false;
        }
        return true;
    }




}
