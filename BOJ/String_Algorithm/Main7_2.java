import java.io.*;

public class Main7_2 {
    static int N, result=0;
    static String[] str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine().split("");

        for(int i=0; i<N; i++) {
            result += Integer.parseInt(str[i]);
        }

        System.out.println(result);
        
    }
    
}