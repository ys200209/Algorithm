import java.util.*;

public class Main14_5 {
    static int N, result=0;
    static int[][] map;
    static boolean[] visited;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        DFS(0);

        System.out.println(result);

    }

    public static void DFS(int count) {
        if (count == N) {
            
            result += 1;
            return;
        }

        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                if (searchQueen(count, i)) continue;
                
                visited[i] = true;
                map[count][i] = 1;
                count += 1;
                DFS(count);
                count -= 1;
                map[count][i] = 0;
                visited[i] = false;
                
            }
        }
    }

    public static boolean searchQueen(int x, int y) {  
        int[] dx = {-1, -1};
        int[] dy = {-1, 1};

        for(int i=0; i<2; i++) {
            int nx = x;
            int ny = y;

            while(true) {
                nx += dx[i];
                ny += dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                if (map[nx][ny] == 1) return true;
            }
        }

        return false;
    }
}