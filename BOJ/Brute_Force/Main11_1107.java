import java.util.*;
import java.io.*;

public class Main11_1107 {
    static int N, M, result=(int)1e9;
    static boolean[] errorBtn;
    static boolean errorPlus;
    static boolean errorMinus;
    static boolean[] visited;
    static Queue<Remote> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        errorBtn = new boolean[10];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            String error = st.nextToken();
            if (error.equals("+")) errorPlus = true;
            else if (error.equals("-")) errorMinus = true;
            else {
                errorBtn[Integer.parseInt(error)] = true;
            }
        }

        if (N == 100) {
            System.out.println("0");
            return;
        }

        System.out.println(Arrays.toString(errorBtn));
        BFS(100);

        System.out.println("result : " + result);
    }

    public static void BFS(int start) {
        pq.offer(new Remote(start, 0, false));
        visited[start] = true;

        for(int i=0; i<10; i++) {
            if (!errorBtn[i]) {
                visited[i] = true;
                pq.offer(new Remote(i, 1, false));
            }
        }

        while(!pq.isEmpty()) {
            // System.out.println("queue.size() : " + pq.size());
            Remote remote = pq.poll();

            int now = remote.now;

            if (!errorPlus && N >= now+1) {
                if (!visited[now+1]) {
                    pq.offer(new Remote(now+1, remote.moveCount+1, true));
                    visited[now+1] = true;
                }
            }
            if (!errorMinus && 0 <= now-1) {
                if (!visited[now-1]) {
                    pq.offer(new Remote(now-1, remote.moveCount+1, true));
                    visited[now-1] = true;
                }
            }

            if (visited[N]) {
                result = Math.min(result, remote.moveCount+1);
                System.out.println("now1 : " + remote.now);
                continue;
            }

            if (remote.isKey) continue; // [+, -] 버튼을 사용한 이력이 있다면 따로 번호를 눌러서는 안된다.

            for(int i=0; i<10; i++) {
                if (!errorBtn[i]) {
                    String num = Integer.toString(now);
                    int update = Integer.parseInt(num + i);
                    if (update > N) break;
                    /*System.out.println("num : " + num);
                    System.out.println("update : " + update);*/

                    if (visited[update]) continue;
                    
                    if (update == N) {
                        result = Math.min(result, remote.moveCount+1);
                        System.out.println("now2 : " + remote.now);
                        break;
                    }
                    visited[update] = true;
                    pq.offer(new Remote(update, remote.moveCount+1, remote.isKey));
                }
            }
        }
    }

}

class Remote implements Comparable<Remote> {

    int now;
    int moveCount;
    boolean isKey;

    public Remote(int now, int moveCount, boolean isKey) {
        this.now = now;
        this.moveCount = moveCount;
        this.isKey = isKey;
    }

    @Override
    public int compareTo(Remote r) {
        return this.moveCount - r.moveCount;
    }

}