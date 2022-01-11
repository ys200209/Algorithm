import java.io.*;

public class Main7_3 {
    static String S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        for(int i=(int)'a'; i<=(int)'z'; i++) {
            sb.append(S.indexOf((char)i) + " ");
        }

        System.out.println(sb);

    }

}
