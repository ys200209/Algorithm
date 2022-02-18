import java.util.*;
import java.io.*;

public class Main27_7 {
    static int T, A, B;
    static String[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            BFS(A, B);

        }

        System.out.println(sb);

    }

    public static void BFS(int A, int B) {
        Queue<DSLR> pq = new PriorityQueue<>();
        pq.offer(new DSLR(A, "", 0));
        boolean[] visited = new boolean[10000];

        while(!pq.isEmpty()) {
            DSLR dslr = pq.poll();
            int number = dslr.number;
            String controll = dslr.controll;
            int count = dslr.count;

            if (number == B) {
                System.out.println("number : " + number + ", B : " + B + ", controll : " + controll + ", count : " + count);
                sb.append(controll + "\n");
                return;
            }
            // D
            int n = (number*2)%10000;
            if (!visited[n]) {
                pq.offer(new DSLR(n, controll+"D", count+1)); 
                visited[n] = true;
            }
            // S
            n = number == 0 ? 9999 : number-1;
            if (!visited[n]) {
                pq.offer(new DSLR(n, controll+"S", count+1)); 
                visited[n] = true;
            } 
            // L
            n = number%1000 * 10 + number/1000;
            if (!visited[n]) {
                pq.offer(new DSLR(n, controll+"L", count+1)); 
                visited[n] = true;
            }
            // R
            n = number%10 * 1000 + number/10;
            if (!visited[n]) {
                pq.offer(new DSLR(n, controll+"R", count+1)); 
                visited[n] = true;
            }
        }
    }
}

class DSLR implements Comparable<DSLR> {

    int number;
    String controll;
    int count;

    public DSLR(int number, String controll, int count) {
        this.number = number;
        this.controll = controll;
        this.count = count;
    }

    @Override
    public int compareTo(DSLR dslr) {
        return this.count - dslr.count;
    }

}