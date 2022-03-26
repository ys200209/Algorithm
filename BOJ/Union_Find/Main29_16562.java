import java.util.*;
import java.io.*;

public class Main29_16562 {
    static int N, M, K;
    static Friend[] friendList;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        friendList = new Friend[N];
        result = new boolean[N+1];

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());


        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            friendList[i] = new Friend(i+1, Integer.parseInt(st.nextToken()));
            i++;
        }

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        Arrays.sort(friendList, new Comparator<Friend>() {
            @Override
            public int compare(Friend f1, Friend f2) {
                return f1.cost - f2.cost;
            }
        });

        int cost = 0;
        for(i=1; i<=N; i++) {
            //System.out.println("cost : " + cost);
            //System.out.println("result : " + Arrays.toString(result));
            if (!result[friendList[i-1].index]) {
                if (K < cost + friendList[i-1].cost) {
                    System.out.println("Oh no");
                    return;
                }
                // System.out.println(friendList[i-1].index + " : " + friendList[i-1].cost);
                cost += friendList[i-1].cost;
                Search(friendList[i-1].index);
            }
        }
        System.out.println(cost);
    }

    public static void Search(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        result[node] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int n : graph.get(num)) {
                if (!result[n]) {
                    result[n] = true;
                    queue.offer(n);
                }
            }
        }
        
    }

}

class Friend {

    int index;
    int cost;

    public Friend(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

}