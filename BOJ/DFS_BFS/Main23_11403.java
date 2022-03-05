import java.util.*;
import java.io.*;

public class Main23_11403 {
    static int N;
    static int[][] board;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N];
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<N; i++) {
            BFS(i);
            for(int j=0; j<N; j++) {
                if (visit[j]) sb.append("1 ");
                else sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int node) {
        visit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int from = queue.poll();

            int j=0;
            for(int to : board[from]) {
                if (to == 1 && !visit[j]) {
                    visit[j] = true;
                    queue.offer(j);
                }
                j++;
            }
        }
    }
}