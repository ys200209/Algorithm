import java.io.*;
import java.util.*;

public class Main27_5 {
    static int N, W, result=0;
    static int[][] map;
    static Event police1, police2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        police1 = new Event(1, 1);
        police2 = new Event(N, N);

        for(int i=0; i<W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int police1_distance = Math.abs(police1.row - x) + Math.abs(police1.column - y);
            int police2_distance = Math.abs(police2.row - x) + Math.abs(police2.column - y);
            

            if (police1_distance < police2_distance) {
                movePolice1(x, y);
            } else if (police1_distance > police2_distance) {
                movePolice2(x, y);
            } else { // ==
                DFS();
            }

            result += Math.min(police1_distance, police2_distance);

        }

        System.out.println(result + "\n" + sb);

    }

    public static void movePolice1(int row, int column) {
        sb.append("1\n");
        police1.row = row;
        police1.column = column;
    }

    public static void movePolice2(int row, int column) {
        sb.append("2\n");
        police2.row = row;
        police2.column = column;
    }

    public static void DFS() {

    }
    
}

class Event {

    int row;
    int column;

    public Event(int row, int column) {
        this.row = row;
        this.column = column;
    }

}