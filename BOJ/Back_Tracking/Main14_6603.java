import java.util.*;
import java.io.*;

public class Main14_6603 {
    static String str="";
    static int K;
    static String[] S;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            S = new String[K];
            int i=0;
            while(st.hasMoreTokens()) {
                S[i] = st.nextToken();
                i++;
            }
            DFS(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int index, int count) {
        if (count == 6) {
            sb.append(str+"\n");
            return;
        }

        for(int i=index; i<K; i++) {
            if (K - i + count < 6) return; 
            // 이 문장을 넣든 안넣든 결과는 같지만 Back-Tracking의 개념대로
            // 어차피 이 조건에 맞지 않는 값은 결과에 추가되지 않기 때문에 의미없는 탐색을 하는것을 방지하는 것.

            str += (S[i] + " ");
            DFS(i+1, count+1);
            str = str.substring(0, str.length() - (S[i].length()+1));
        }
    }
}