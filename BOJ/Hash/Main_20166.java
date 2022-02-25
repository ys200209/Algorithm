import java.util.*;
import java.io.*;

public class Main_20166 {
    static int N, M, K, count;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1}; // 12시부터 시계 방향으로 회전
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static String[][] world;
    static String word;
    static String[] word_list;
    static Map<String, Integer> map = new HashMap<>(); // 중복된 문자열 관리
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        world = new String[N][M];

        for(int i=0; i<N; i++) {
            world[i] = br.readLine().split("");
        }

        for(int k=0; k<K; k++) {
            count = 0;
            word = br.readLine();

            if (map.get(word) != null) {
                sb.append(map.get(word) + "\n");
                continue;
            }

            word_list = word.split("");

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if (world[i][j].equals(word_list[0])) { // 첫 글자가 일치할때만 그 위치부터 탐색
                        BFS(i, j);
                    }
                }
            }
            map.put(word, count);
            sb.append(count + "\n");
        }

        System.out.println(sb);

    }

    public static void BFS(int x, int y) { 
        Queue<Walk> queue = new LinkedList<>();
        queue.offer(new Walk(x, y, world[x][y]));

        while(!queue.isEmpty()) {
            Walk walk = queue.poll();
            int row = walk.row;
            int column = walk.column;

            if (walk.s.equals(word)) {
                count++;
                continue;
            }

            for(int i=0; i<dx.length; i++) {
                int nx = row + dx[i];
                int ny = column + dy[i];

                if (nx < 0) nx = N-1;
                if (nx >= N) nx = 0;
                if (ny < 0) ny = M-1;
                if (ny >= M) ny = 0;

                if (world[nx][ny].equals(word_list[walk.s.length()])) {
                    queue.offer(new Walk(nx, ny, walk.s + world[nx][ny]));
                }

            }


        }
    }
    
}

class Walk {

    int row, column;
    String s;

    public Walk(int row, int column, String s) {
        this.row = row;
        this.column = column;
        this.s = s;
    }

}