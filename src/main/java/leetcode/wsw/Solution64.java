package leetcode.wsw;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution64 {

    public static void main(String[] args) {



        int i = new Solution64().sumNums(3);
        System.out.println(i);
    }
    public int sumNums(int n) {
        int sum=0;
        boolean b=n>0&&(sum=((n--)+sumNums(n)))>0;
        return sum;
    }
}
