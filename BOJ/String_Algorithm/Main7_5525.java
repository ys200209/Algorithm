import java.util.*;
import java.io.*;

public class Main7_5525 {
    static int N, M, result=0;
    static String S;
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        StringBuilder str = new StringBuilder();
        str.append("IOI");
        for(int i=2; i<=N; i++) {
            str.append("OI");
        }

        int slice=0;
        int index=-1;
        while((index = S.substring(slice).indexOf(str.toString())) != -1) {
            slice += index+1;
            result++;
        }

        System.out.println(result);

    }

}
