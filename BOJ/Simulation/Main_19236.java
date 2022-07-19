import java.util.*;
import java.io.*;

public class Main_19236 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int N=4, result=0;
    static Pisces[][] board = new Pisces[N][N];
    static Shark shark;
    static ArrayList<Fish> fishes = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        init();

        System.out.println("-----------------------");
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(board[i][j] instanceof Shark ? "S " : ((Fish)board[i][j]).number + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");

        eat();

        System.out.println("-----------------------");
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(board[i][j] instanceof Shark ? "S " : ((Fish)board[i][j]).number + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");

        System.out.println("count : " + fishes.size());

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                board[i][j] = new Fish(i, j, number, d-1);
                fishes.add((Fish)board[i][j]);
                j++;
            }
        }
        Fish fish = (Fish) board[0][0];
        shark = new Shark(0, 0, fish.number, fish.d);
        fishes.remove(fish);

        board[0][0] = shark;
        
        Collections.sort(fishes, (f1, f2) -> {
            return f1.number - f2.number;
        });
    }

    public static void eat(Fish fish) {
        if (fish == null) return;

        shark.x = fish.x;
        shark.y = fish.y;
        shark.score = fish.number;
        shark.d = fish.d;
        moveFish();
        moveShark();
    }

    public static void moveFish() {
        for(int i=0; i<fishes.size(); i++) {
            Fish fish = fishes.get(i);
            int x = fish.x;
            int y = fish.y;

            int nx = x + dx[fish.d];
            int ny = y + dy[fish.d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] instanceof Shark) {
                for(int j=1; j<=7; j++) {
                    nx = x + dx[(fish.d + j) % 8];
                    ny = y + dy[(fish.d + j) % 8];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] instanceof Shark) continue;

                    fish.x = nx;
                    fish.y = ny;
                    fish.d = j;
                    Fish changeFish = (Fish)board[nx][ny];
                    board[nx][ny] = fish;
                    changeFish.x = x;
                    changeFish.y = y;
                    board[x][y] = changeFish;
                    break;
                }
            } else {
                fish.x = nx;
                fish.y = ny;
                Fish changeFish = (Fish)board[nx][ny];
                board[nx][ny] = fish;
                changeFish.x = x;
                changeFish.y = y;
                board[x][y] = changeFish;
            }

        }
    }

    public static void moveShark() {

    }

    public static void change() {}

}

interface Pisces {

    

}

class Fish implements Pisces {

    int x;
    int y;
    int number;
    int d;
    // boolean isShark;

    public Fish(int x, int y, int number, int d/*, boolean isShark */) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.d = d;
        // this.isShark = isShark;
    }

}

class Shark implements Pisces {

    int x;
    int y;
    int score;
    int d;
    // boolean isShark;

    public Shark(int x, int y, int score, int d/*, boolean isShark */) {
        this.x = x;
        this.y = y;
        this.score = score;
        this.d = d;
        // this.isShark = isShark;
    }

}