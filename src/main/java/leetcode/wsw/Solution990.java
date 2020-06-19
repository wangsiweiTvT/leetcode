package leetcode.wsw;

import java.awt.*;
import java.beans.EventHandler;
import java.util.Arrays;
import java.util.HashSet;

public class Solution990 {

    public static void main(String[] args) {
        //["e==e","d!=e","c==d","d!=e"]
        //["f==b","c==b","c==b","e!=f"]
        //["h==j","c!=g","e==j","f!=e","g!=e","j==h","h!=e","j!=a"]
        //["a==b","b!=c","c==a"]
        //["b!=c","a==b","e!=d","b!=f","a!=b"]
        //["b!=f","c!=e","f==f","d==f","b==f","a==f"]

        String[] s={"b!=f","c!=e","f==f","d==f","b==f","a==f"};
        boolean b = new Solution990().equationsPossible(s);
        System.out.println(b);

    }


    public boolean equationsPossible(String[] equations) {

        int[] groups = new int[(int) 'z' + 1];
        HashSet<String> nonEquals = new HashSet<>();
        out:
        for (int i=0;i<equations.length;i++){

            char p = equations[i].charAt(0);
            char r = equations[i].charAt(3);
            if (equations[i].charAt(1)=='!') {
                if (p==r) return false;
                nonEquals.add(equations[i]);
            }
            else {
                if (p==r) continue out;
                if (p<r) {
                    groups[r]=p;
                    if (groups[p]==0) groups[p]=p;
                }
                else {
                    groups[p] = r;
                    if (groups[r]==0) groups[r]=r;
                }
            }
        }
        if (nonEquals.size()==0) return true;
        for (String s:nonEquals){
            char p = s.charAt(0);
            char r = s.charAt(3);
            if (groups[r]==0||groups[p]==0) continue;
            while (groups[r]!=r) r=(char) groups[r];
            while (groups[p]!=p) p=(char) groups[p];
            if (r==p) return false;
        }
        return true;

    }

}
