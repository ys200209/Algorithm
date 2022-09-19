package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17471 {
    static int N, result=(int)1e9;
    static int[] amount;
    static boolean[] visited, select;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        amount = new int[N+1];
        select = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        int i=1;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            amount[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            while(st.hasMoreTokens()) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        DFS(1, 0);

        System.out.println("result = " + (result == (int)1e9 ? -1 : result));
    }

    private static void DFS(int from, int to) {

        for(int i=from; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            select[i] = true;
            if (checkDiv()) {
                result = Math.min(result, getScore());
            }

            for(int j=to; j<=graph.get(i).size(); j++) {
                select[j] = true;
                visited[j] = true;
                DFS(i, j+1);
                visited[j] = false;
                select[j] = false;
            }
            select[i] = false;
            visited[i] = false;
        }


    }

    private static boolean checkDiv() {
        int count = 0;
        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                if (count == 1) return false;
                BFS(i);
                count++;
            }
        }
        return true;
    }

    private static void BFS(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(number);

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (visited[poll]) continue;

            visited[poll] = true;
            for (Integer num : graph.get(poll)) {
                if (visited[num]) continue;
                queue.offer(num);
                visited[num] = true;
            }
        }

    }

    private static int getScore() {
        int score1 = 0;
        int score2 = 0;

        for(int i=1; i<=N; i++) {
            if (select[i]) score1 += amount[i];
            else score2 += amount[i];
        }

        return Math.abs(score1 - score2);
    }

}