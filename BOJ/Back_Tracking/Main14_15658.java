import java.util.*;
import java.io.*;

public class Main14_15658 {
    static int N, MAX=-1000000001, MIN=1000000001;
    static int[] numbers;
    static int[] cal;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        cal = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        i=0;
        while(st.hasMoreTokens()) {
            cal[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=0; i<N; i++) {
            DFS(numbers[i], i+1, 0);
        }
        
        System.out.println(MAX + "\n" + MIN);
    }

    public static void DFS(int now, int index, int count) {
        if (count == N-1) {
            MAX = Math.max(MAX, now);
            MIN = Math.min(MIN, now);
            return;
        }

        for(int i=index; i<N; i++) {
            if (cal[0] > 0) {
                cal[0] -= 1;
                DFS(now + numbers[i], i+1, count+1);
                cal[0] += 1;
            }
            if (cal[1] > 0) {
                cal[1] -= 1;
                DFS(now - numbers[i], i+1, count+1);
                cal[1] += 1;
            }
            if (cal[2] > 0) {
                cal[2] -= 1;
                DFS(now * numbers[i], i+1, count+1);
                cal[2] += 1;
            }
            if (cal[3] > 0) {
                cal[3] -= 1;
                if (now < 0 && numbers[i] > 0) DFS(((now*-1) / numbers[i]) * -1, i+1, count+1);
                else DFS(now / numbers[i], i+1, count+1);
                cal[3] += 1;
            }
        }
    }

}
