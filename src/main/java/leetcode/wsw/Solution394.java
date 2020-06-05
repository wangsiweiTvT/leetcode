package leetcode.wsw;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Solution394 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new Solution394().decodeString("3[abc]");
        System.out.println(s);

    }


    public String decodeString(String s) {

        ArrayList<Integer> numStack = new ArrayList<>();
        ArrayList<Character> cStack = new ArrayList<>();
        ArrayList<Character> tempStack = new ArrayList<>();

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c>='0'&&c<='9') {
                StringBuffer sb = new StringBuffer();

                sb.append(c);
                while (s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    sb.append(s.charAt(i+1));
                    i++;
                }
                numStack.add(Integer.parseInt(sb.toString()));
                continue;
            }
            if (c==']'){
                StringBuffer sb = new StringBuffer();
                for (int j=cStack.size()-1;j>=0;j--){
                    if (cStack.get(cStack.size()-1)=='[') {
                        cStack.remove(cStack.size()-1);
                        break;
                    }
                    tempStack.add(cStack.get(cStack.size()-1));
                    cStack.remove(cStack.size()-1);
                }

                for (int j=tempStack.size()-1;j>=0;j--){
                    sb.append(tempStack.get(tempStack.size()-1));
                    tempStack.remove(tempStack.size()-1);
                }

                String group = sb.toString();
                if (numStack.size()==0) return group;

                int num=numStack.get(numStack.size()-1);
                numStack.remove(numStack.size()-1);
                for (int j=0;j<num-1;j++) sb.append(group);
                String temp = sb.toString();
                for(int p=0;p<temp.length();p++) cStack.add(temp.charAt(p));
                continue;
            }
            cStack.add(c);
        }


        StringBuffer sb = new StringBuffer();
        for (int j=cStack.size()-1;j>=0;j--){
            tempStack.add(cStack.get(cStack.size()-1));
            cStack.remove(cStack.size()-1);
        }
        for (int j=tempStack.size()-1;j>=0;j--){
            sb.append(tempStack.get(tempStack.size()-1));
            tempStack.remove(tempStack.size()-1);
        }

        return sb.toString();
    }
}
