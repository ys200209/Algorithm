import java.security.KeyFactory;
import java.util.*;

public class Main13_20 {
    public static boolean result=false;
    public static int N;
    public static String[][] map;
    // public static int[][] teacher;

    public static void main(String[] args) {

        // 삼성전자 SW 역량 테스트 (난이도 : 중상)
        
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new String[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = scanner.next();
            }
        }

        DFS(0);

        if (!result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        System.out.println();
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }

    public static void DFS(int obs) {
        if (obs > 3) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j].equals("T")) {
                        for(int k=0; k<4; k++) {
                            if (result) return;

                            isSearch(i, j, dx[k], dy[k]); // 학생이 발견되지 않을때마다 4방향으로 탐색
                        }
                        
                    }
                    
                }
                
            }

            System.out.println("발견되지 않음");
            result = false;
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    obs += 1;
                    DFS(obs);
                    if (result) {
                        result = false;
                    } else {
                        System.out.println("Search");
                        for(int k=0; k<N; k++) {
                            System.out.println(Arrays.toString(map[k]));
                        }
                        return;
                    }
                    obs -= 1;
                    map[i][j] = "X";
                }
            }
        }

        
    }

    public static void isSearch(int x, int y, int dx, int dy) { // 학생이 모두 발견이 안되면 false, 한명이라도 발견되면 true.

        // 선생님 T의 위치에서 각각 복도를 바라보며 학생을 찾기. 
        // 기본값은 return true, 만약 발견된다면 return false;

        int nx = x + dx;
        int ny = y + dy;

        if (result) return;

        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if (map[nx][ny].equals("S")) {
                result = true;
                return;
            }
            if (map[nx][ny].equals("O")) {
                return;
            }
            if (map[nx][ny].equals("X")) {
                isSearch(nx, ny, dx, dy);
            }
           
        }
        
    }
    
}
