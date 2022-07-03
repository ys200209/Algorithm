import java.util.*;
import java.io.*;

public class Main_17135 {
    static int N, M, D, result=0, score, enemy;
    static int[][] board;
    static ArrayList<Enemy> copyEnemies, enemies = new ArrayList<>();
    static Archer[] archers = new Archer[3];
    static boolean[] kill;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    enemies.add(new Enemy(i, j));
                }
                j++;
            }
        }
        

        DFS(0, 0);

        System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count == 3) {
            kill = new boolean[enemies.size()];
            score = 0; // 잡은 적의 수
            enemy = enemies.size(); // 남아있는 적의 수

            copyEnemies();

            while(enemy > 0) { // 적이 남지 않을때까지 게임 진행 
                checkDistance();
                Attack();
                move();
            }
            
            result = Math.max(result, score);
            return;
        }

        for(int i=index; i<M; i++) {
            archers[count] = new Archer(N, i, -1);
            DFS(i+1, count+1);
        }

    }

    public static void copyEnemies() {
        copyEnemies = new ArrayList<>();

        for (Enemy enemy : enemies) {
            copyEnemies.add(new Enemy(enemy.x, enemy.y));
        }
    }

    public static void checkDistance() {
        for(int i=0; i<3; i++) {
            int index = -1;
            int distance = (int)1e9;

            for(int j=0; j<copyEnemies.size(); j++) {
                if (kill[j]) continue; // 이미 잡은 적이라면 무시

                int dis = Math.abs(archers[i].x - copyEnemies.get(j).x) + Math.abs(archers[i].y - copyEnemies.get(j).y);

                if (dis > D) continue; // 궁수의 사거리 밖이라면 무시

                if (distance > dis) {
                    index = j;
                    distance = dis;
                } else if (distance == dis) {
                    if (copyEnemies.get(index).y > copyEnemies.get(j).y) {
                        index = j;
                    }
                }
            }
            archers[i].index = index;
        }
    }

    public static void Attack() {
        for(int i=0; i<3; i++) {
            if (archers[i].index != -1 && !kill[archers[i].index]) {
                kill[archers[i].index] = true;
                enemy--;
                score++;
            }
        }
    }

    public static void move() {
        for(int i=0; i<copyEnemies.size(); i++) {
            if (kill[i]) continue; // 잡혔다면 움직이지 않는다.

            copyEnemies.get(i).x++;

            if (copyEnemies.get(i).x >= N) { // 만약 성으로 나갔다면 남은 적의 수를 감소시킴
                kill[i] = true;
                enemy--;
            }
        }
    }

}

class Archer {

    int x;
    int y;
    int index; // 잡을 적의 인덱스
    public Archer(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Enemy {

    int x;
    int y;
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}