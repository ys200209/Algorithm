import java.security.KeyFactory;
import java.util.*;

public class Main13_20 {
    public static int N;
    public static String[][] map;
    public static boolean search;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        map = new String[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = scanner.next();
            }
        }

        DFS(0);

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        if (search) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void DFS(int count) {
        if (count == 3 && !search) {

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j].equals("T")) {
                        if (isSearch(i, j)) continue;
                        else return;
                    }
                }
            }
            search = true;
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    count += 1;
                    DFS(count);
                    count -= 1;
                    map[i][j] = "X";
                }
                if(search) return;
            }
        }
    }

    public static boolean isSearch(int x, int y) {
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int nx, ny;

        for(int i=0; i<4; i++) {
            nx = x;
            ny = y;
            while(true) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break; // 해당 직선 상에 존재하지 않으면 true
                if (map[nx][ny].equals("O")) break;
                else if (map[nx][ny].equals("S")) return false; // 직선 상에 학생과 마주치면 false
            }
            
        }
        return true;
    }
}
