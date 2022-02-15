import java.util.*;
import java.io.*;

public class Main26_4 {
    static int N, result;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] B;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        B = new boolean[N+1];
        B[1] = true;
        double s = System.nanoTime();
        for(int i=2; i<=Math.sqrt(N); i++) {
            if (!B[i]) {
                for(int j=i*2; j<=N; j+=i) {
                    B[j] = true;
                }
            }
        }

        for (int i = 1; i<=N ; i++) {
            if(!B[i]) list.add(i);
        }

        System.out.println("time : " + (System.nanoTime() - s));

        int start = 0;
        int end = 0;
        int sum = 0;
        
        // list.add(0);
        // System.out.println(list);

        /*while(start < list.size() && end < list.size()) {
            if (sum < N) {
                sum += list.get(end++);
            } else if (sum >= N) {
                sum -= list.get(start++);
            }
            
            if (sum == N) result++;
            
        }*/
        System.out.println("size : " + list.size());
        while (true){
            System.out.println("start : " + start + ", end : " + end);
            if (sum >= N){
                sum -= list.get(start++);
            } else if(end == list.size()){
                break;
            } else {
                sum += list.get(end++);
            }
            if(N == sum) result++;
        }

        System.out.println(result);

    }

}
