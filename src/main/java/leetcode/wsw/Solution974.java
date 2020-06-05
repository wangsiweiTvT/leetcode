package leetcode.wsw;

import java.io.*;
import java.nio.charset.StandardCharsets;

class Solution974 {


    public static void main(String[] args) throws IOException {

        InputStream in = new FileInputStream(new File("C:\\Users\\sww_a\\Desktop\\sample\\美日澳联合军演，我电侦船“抢风头”.txt"));
        // InputStreamReader reader = new InputStreamReader(in, charSet);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GB2312"));

        byte[] bytes = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true){
            int len=in.read(bytes);
            if (len==-1) break;
            String s1 = new String(bytes, 0, len, StandardCharsets.UTF_8);
            System.out.println("=======");
            System.out.println(s1);
            byteArrayOutputStream.write(bytes,0,len);
//            String s = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
//            System.out.println("======="+s);
        }

        String s = new String(byteArrayOutputStream.toByteArray());
        System.out.println("======="+s);

    }
    public int subarraysDivByK(int[] A, int K) {

        int[] index=new int[K];
        int r=0;
        int sum=0;
        for (int i=0;i<A.length;i++) {
            int idx=(sum+=A[i])%K;
            if (idx<0) idx+=K;
            index[idx]++;
        }
        for (int i=0;i<index.length;i++){
            if (index[i]==0||index[i]==1) continue;
            int temp=0;
            for (int j=index[i]-1;j>0;j--)temp+=j;
            r+=temp;
        }
        return index[0]>0?r+index[0]:r;
    }
}
