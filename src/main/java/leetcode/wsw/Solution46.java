package leetcode.wsw;

public class Solution46 {
    public static void main(String[] args) {
        int i = new Solution46().translateNum(220);
    }

    public int translateNum(int num) {
        if (num<10) return 1;
        if(num<26)return 2;

        String s = String.valueOf(num);
        int[] result = new int[s.length()+1];
        if ((s.charAt(0) - '0')*10+(s.charAt(1)-'0')>25) result[0]=0;
        else result[0]=1;
        result[1]=1;
        for (int i=1;i<s.length();i++){
            int p = s.charAt(i - 1) - '0';
            int r = s.charAt(i) - '0';
            if (p==0)result[i+1]=result[i];
            else {
                if (p*10+r>25) result[i+1]=result[i];
                else result[i+1]=result[i-1]+result[i];
            }

        }

        return result[s.length()];

    }
}
