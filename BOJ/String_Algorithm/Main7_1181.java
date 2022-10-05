package BOJ.String_Algorithm;

import java.io.*;
import java.util.*;

public class Main7_1181 {
    static Queue<String> pq = new PriorityQueue<>((s1, s2) -> {
        if (s1.length() == s2.length()) return s1.compareTo(s2);
        else if (s1.length() > s2.length()) return 1;
        else return -1;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            if (!pq.contains(str)) pq.offer(str);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }
        System.out.println(sb);
    }
}
