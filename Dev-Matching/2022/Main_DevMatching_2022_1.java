import java.nio.channels.NonWritableChannelException;
import java.util.*;

public class Main_DevMatching_2022_1 {
    static int N, now=0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[][] answer = null;

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}}));
        // [[1,2,0,4,3],[3,4,0,2,1]]
    }
    
    public static int[][] solution(int[][] dist) {
        N = dist.length;
        visited = new boolean[N];

        for(int i=0; i<dist.length; i++) graph.add(new ArrayList<>());

        for(int i=0; i<dist.length; i++) {
            for(int j=0; j<dist[0].length; j++) {
                graph.get(i).add(dist[i][j]);
            }
        }

        for(int i=0; i<dist.length; i++) {
            visited[i] = true;
            result.add(i);
            // System.out.println("--------------- : " + i);
            DFS(i, 0);
            result.remove(result.size()-1);
            visited[i] = false;
        }

        
        /*for(int i=0; i<2; i++) {
            System.out.println("answer : " + Arrays.toString(answer[i]));
        }*/

        return answer;
    }

    public static void DFS(int index, int count) {
        // System.out.println(count);
        if (count == N-1) {
            // System.out.println("result : " + result);

            if (checkReverse(index)) {
                // System.out.println("ansewr : " + result);
                answer = new int[2][N];
                for(int i=0; i<N; i++) {
                    answer[0][i] = result.get(i);
                    answer[1][i] = result.get(result.size()-i-1);
                }
            }
            return;
        }
        
        for(int i=0; i<graph.size(); i++) {
            if (graph.get(index).get(i) == 0) continue;

            if (visited[i]) continue;

            if (now >= graph.get(index).get(i)) return;

            if (answer != null) return;

            visited[i] = true;
            int n = now;
            now = graph.get(index).get(i);
            result.add(i);
            DFS(index, count+1);
            now = n;
            result.remove(result.size()-1);
            visited[i] = false;

        }
        
    }

    public static boolean checkReverse(int index) {
        int reverseNum = (int)1e9;
        for(int i=result.size()-1; i>=0; i--) {
            // System.out.println(graph.get(index).get(result.get(i)));
            if (reverseNum <= graph.get(index).get(result.get(i))) return false;

            reverseNum = graph.get(index).get(result.get(i));
        }

        return true;
    }

}