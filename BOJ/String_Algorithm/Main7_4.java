import java.io.*;
import java.util.*;

public class Main7_4 {
    static int T, R;
    static String[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            S = st.nextToken().split("");

            for(int j=0; j<S.length; j++) {
                for(int k=0; k<R; k++) {
                    sb.append(S[j]);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

}