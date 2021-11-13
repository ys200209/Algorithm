import java.util.*;

class Main13_16 {
    public static int N, M, answer=0, score=0;
    public static int[][] map, temp;

    public static void main(String[] args) {

        /*
            - 삼성전자 SW 역량테스트
            
            인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었습니다. 다행히 바이러스는 아직 퍼지지 
            않았고, 바이러스의 확산을 박기 위해 연구소에 벽을 세우려고 합니다.
            연구소는 크기가 N x M인 직사각형으로 나타낼 수 있으며, 직사각형은 1 X 1 크기의 정사각형으로 나누어져 있습니다.
            연구소는 빈칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지합니다.
            일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈칸으로 모두 퍼져나갈 수 있습니다.
            새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 합니다.

            벽 3개를 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 할 때 지도에서 안전 영역 크기의 최댓값을 구하는
            프로그램을 작성하세요. (3 <= N, M <= 8) ( 0은 빈칸, 1은 벽, 2는 바이러스가 있는 위치이다 )

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

        */

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        temp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        DFS(0);

        System.out.println(answer);

    }

    public static void DFS(int count) {
        if (count == 3) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if (map[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            answer = Math.max(answer, getScore());
            return;
        } 
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    count += 1;
                    DFS(count);
                    map[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void virus(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    public static int getScore() {
        score=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (temp[i][j] == 0) {
                    score+=1;
                }
            }
        }
        return score;
    }

}