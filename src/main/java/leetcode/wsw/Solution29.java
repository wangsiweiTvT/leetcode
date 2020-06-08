package leetcode.wsw;

public class Solution29 {


    public static void main(String[] args) {
         int[][] matix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] ints = new Solution29().spiralOrder(matix);

    }

    private static int i=0;
    public int[] spiralOrder(int[][] matrix) {
        int[] res = new int[matrix.length * matrix[0].length];
        if (matrix.length==0) return new int[0];
        if (matrix.length==1) return matrix[0];
        if (matrix[0].length==0) return new int[matrix.length];
        if (matrix[0].length==1) {
            for (int l=0;l<matrix.length;l++) res[i++]=matrix[l][0];
            return res;
        }
        int min = Math.min(matrix.length, matrix[0].length);
        for (int pos=0;pos<=min-2;pos++)cycle(pos,pos,matrix,res);
        return res;

    }
    private void cycle(int row,int column,int[][] matrix,int[] res){

        if (row==matrix.length-1-row) {
            for (int c=column;c<=matrix[0].length-1-column;c++) res[i++]=matrix[row][c];
            return;
        }
        if (column==matrix[0].length-1-column){
            for (int r=row;r<=matrix.length-1-row;r++) res[i++]=matrix[r][column];
            return;
        }
        for (int c=column;c<=matrix[0].length-1-column;c++) res[i++]=matrix[row][c];
        if (row+1==matrix.length-1-row);
        else for (int r=row+1;r<=matrix.length-2-row;r++) res[i++]=matrix[r][matrix[0].length-1-column];
        for (int c=matrix[0].length-1-column;c>=column;c--) res[i++]=matrix[matrix.length-1-row][c];
        if (row+1==matrix.length-1-row);
        else for (int r=matrix.length-2-row;r>=row+1;r--) res[i++]=matrix[r][column];
    }
}
