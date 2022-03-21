import java.util.*;
import java.io.*;

public class Main_11003 {
    static int N, L;
    static Queue<Num> pq = new PriorityQueue<>(new Comparator<Num>() {
        @Override
        public int compare(Num n1, Num n2) {
            return n1.number - n2.number;
        }
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            pq.offer(new Num(n, i));

            while(!pq.isEmpty() && i - pq.peek().index >= L) pq.poll();
            
            sb.append(pq.peek().number + " ");
            i++;
        }
        System.out.println(sb);
    }
}

class Num {

    int number;
    int index;

    public Num(int number, int index) {
        this.number = number;
        this.index = index;
    }

}