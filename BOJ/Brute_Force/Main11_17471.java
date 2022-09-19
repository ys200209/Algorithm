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
        visited = new boolean[N+1];
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

        /*for(i=1; i<=N; i++) {
            System.out.println("i : " + i);
            for (Integer integer : graph.get(i)) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }*/

        for(i=1; i<=N; i++) {
            System.out.println("i : " + i);
            select(i);
            System.out.println();
        }

        System.out.println("result = " + (result == (int)1e9 ? -1 : result));
    }

    private static void select(int target) {
        System.out.print(target + " ");
        if (visited[target]) {
//            System.out.println("already Visited!");
            return;
        }

        select[target] = true;
        visited[target] = true;
        if (checkDiv()) {
            result = Math.min(result, getScore());
//            System.out.println();
//            System.out.println(Arrays.toString(select) + ", result : " + result);
        } else {
            select[target] = false;
            visited[target] = false;
//            System.out.println("!checkDiv() return");
            return;
        }

        for (int num : graph.get(target)) {
            select(num);
        }
        select[target] = false;
        visited[target] = false;
    }

    private static boolean checkDiv() {
        int count = 0;
        boolean[] checkVisited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            if (visited[i]) checkVisited[i] = true;
        }

        System.out.println("\ncheckVisited : " + Arrays.toString(checkVisited));
        for(int i=1; i<=N; i++) {
            if (!checkVisited[i]) {
                if (count == 1) return false;
                BFS(i, checkVisited);
                count++;
                System.out.println("checkVisited : " + Arrays.toString(checkVisited));
            }
        }
        return true;
    }

    private static void BFS(int number, boolean[] checkVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(number);
        checkVisited[number] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer num : graph.get(poll)) {
                if (checkVisited[num]) continue;
                queue.offer(num);
                checkVisited[num] = true;
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