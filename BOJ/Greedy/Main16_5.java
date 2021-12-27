import java.util.*;
import java.io.*;

class Main16_5 {
    public static int N;
    public static long result=0;
    public static int[] distance, amounts;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        distance = new int[N-1];
        amounts = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k=0;
        while(st.hasMoreTokens()) {
            distance[k] = Integer.parseInt(st.nextToken());
            k++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        k=0;
        while(st.hasMoreTokens()) {
            amounts[k] = Integer.parseInt(st.nextToken());
            k++;
        }

        long amo = amounts[0];
        
        for(int i=0; i<distance.length; i++) {

            if (amo > amounts[i]) amo = amounts[i];

            long dis = distance[i];

            result += dis * amo;
        }

        System.out.println(result);

    }

}