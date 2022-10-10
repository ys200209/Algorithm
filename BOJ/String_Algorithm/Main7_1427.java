package BOJ.String_Algorithm;

import java.io.*;
import java.util.*;

public class Main7_1427 {
    static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            pq.offer(str.charAt(i) - '0');
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        System.out.println(sb);
    }
}
