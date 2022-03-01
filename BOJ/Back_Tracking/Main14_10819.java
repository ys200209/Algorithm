import java.util.*;
import java.io.*;

public class Main14_10819 {
    static int N, result=0;
    static int[] A, cal;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        cal = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        DFS(0);

        System.out.println(result);
    }

    public static void DFS(int count) {
        if (count == N) {
            calculate();
            return;
        }

        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cal[count] = A[i];
                DFS(count+1);
                cal[count] = 0;
                visited[i] = false;
            }
        }
    }

    public static void calculate() {
        int sum=0;

        for(int i=0; i<N-1; i++) {
            sum += Math.abs(cal[i] - cal[i+1]);
        }

        result = Math.max(result, sum);
    }

}