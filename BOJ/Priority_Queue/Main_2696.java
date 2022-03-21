import java.util.*;
import java.io.*;

public class Main_2696 {
    static int T, M;
    static Queue<Integer> frontQueue;
    static Queue<Integer> backQueue;
    static Queue<Integer> resultQueue;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            M = Integer.parseInt(br.readLine());
            frontQueue = new PriorityQueue<>(Collections.reverseOrder());
            backQueue = new PriorityQueue<>();
            resultQueue = new LinkedList<>();

            int j=1;
            for(int i=0; i<=M/10; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()) {
                    if (j % 2 == 1) backQueue.offer(Integer.parseInt(st.nextToken()));
                    else frontQueue.offer(Integer.parseInt(st.nextToken()));
                    
                    if (!frontQueue.isEmpty()) {
                        if (frontQueue.peek() > backQueue.peek()) {
                            backQueue.offer(frontQueue.poll());
                            frontQueue.offer(backQueue.poll());
                        }
                    }

                    if (j % 2 == 1) resultQueue.offer(backQueue.peek());
                    j++;
                }
            }
            sb.append(resultQueue.size() + "\n");
            j = 0;
            while(!resultQueue.isEmpty()) {
                if (j % 10 == 0 && j >= 10) sb.append("\n");
                sb.append(resultQueue.poll() + " ");
                j++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}