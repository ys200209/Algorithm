import java.util.*;
import java.io.*;

public class Main16_19236 {
    static int result=0;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static Pisces[][] board = new Pisces[4][4];
    static Pisces shark;
    static ArrayList<Fish> fishes = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException {

        init();

        DFS((Shark)shark);

    }

    public static void init() throws IOException {
        BufferedReader br;
        StringTokenizer st;

        for(int i=0; i<4; i++) {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine(), " ");

            int j=0;
            while(st.hasMoreElements()) {
                int number = Integer.parseInt(st.nextToken());
                int vector = Integer.parseInt(st.nextToken());

                board[i][j] = new Fish(i, j, number, vector-1);
                fishes.add((Fish)board[i][j]);
                j++;
            }
            Collections.sort(fishes, (fish1, fish2) -> {
                return fish1.number - fish2.number;
            });
        }
        
        fishes.remove(board[0][0]);
        board[0][0] = new Shark(0, 0, ((Fish)board[0][0]).vector, 0);
        shark = board[0][0];
    }

    public static void DFS(Shark shark) {

        fishMove();
        Shark temp = sharkMove(shark);

        if (temp == null) return;

        result = Math.max(result, temp.score);
        DFS(temp);
    }

    public static void fishMove() {
        for(int i=0; i<fishes.size(); i++) {
            Pisces pis = fishes.get(i);
            int x = ((Fish)pis).x;
            int y = ((Fish)pis).y;
            int vector = ((Fish)pis).vector;
            int nx = 0;
            int ny = 0;
            for(int j=0; j<8; j++) {
                int nv = (j + vector) % 8;
                nx = x + dx[nv];
                ny = y + dy[nv];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                if (board[nx][ny] instanceof Shark) continue;

                fishes.get(i).vector = nv;
                break;
            }

            change(fishes.get(i), (Fish)board[nx][ny]);

        }
    }

    public static Shark sharkMove(Shark shark) {
        

        return null;
    }

    public static void change(Fish f1, Fish f2) {
        int tempX = f1.x;
        int tempY = f1.y;
        Fish temp = f1;

        board[tempX][tempY] = f2;
        f1.x = f2.x;
        f1.y = f2.y;
        f2.x = temp.x;
        f2.y = temp.y;
        board[f1.x][f1.y] = temp;

    }
}

interface Pisces { }

class Fish implements Pisces{
    int x;
    int y;
    int number;
    int vector;

    public Fish(int x, int y, int number, int vector) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.vector = vector;
    }
}

class Shark implements Pisces{
    int x;
    int y;
    int vector;
    int score;

    public Shark(int x, int y, int vector, int score) {
        this.x = x;
        this.y = y;
        this.vector = vector;
        this.score = score;
    }
}