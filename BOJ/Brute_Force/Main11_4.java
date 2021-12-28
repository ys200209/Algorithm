import java.util.*;

public class Main11_4 {
    public static int N, M, count=0, min_value=(int)1e9;
    public static String[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            map[i] = scanner.next().split("");
        }

        search(0, 0);

        System.out.println(min_value);

    }

    public static void search(int x, int y) {
        if (x < 0 || x > N-8 || y < 0 || y > M-8) return;

        if (visited[x][y]) return;

        start_W(x, y);
        start_B(x, y);

        visited[x][y] = true;
        
        search(x-1, y);
        search(x+1, y);
        search(x, y-1);
        search(x, y+1);
        
    }

    public static void start_W(int x, int y) {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (!map[x+i][y+j].equals("W")) count+=1;
                } else if (i % 2 == 0 && j % 2 == 1) {
                    if (!map[x+i][y+j].equals("B")) count+=1;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    if (!map[x+i][y+j].equals("B")) count+=1;
                } else if (i % 2 == 1 && j % 2 == 1) {
                    if (!map[x+i][y+j].equals("W")) count+=1;
                }
            }
        }

        if (count < min_value) min_value = count;
        count = 0;
    }

    public static void start_B(int x, int y) {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (!map[x+i][y+j].equals("B")) count+=1;
                } else if (i % 2 == 0 && j % 2 == 1) {
                    if (!map[x+i][y+j].equals("W")) count+=1;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    if (!map[x+i][y+j].equals("W")) count+=1;
                } else if (i % 2 == 1 && j % 2 == 1) {
                    if (!map[x+i][y+j].equals("B")) count+=1;
                }
            }
        }

        if (count < min_value) min_value = count;
        count = 0;
    }
    
}