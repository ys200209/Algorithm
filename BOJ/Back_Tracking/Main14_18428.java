import java.util.*;
import java.io.*;

public class Main14_18428 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static String[][] map;
    static ArrayList<Student> students = new ArrayList<>();
    static boolean result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("S")) students.add(new Student(i, j));
                j++;
            }
        }
        
        DFS(0, 0);

        if (result) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void DFS(int index, int count) {
        if (count == 3) {
            if (search()) result = true;
            return;
        }

        for(int i=index; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    DFS(i, count+1);
                    map[i][j] = "X";
                }
            }
        }
    }

    public static boolean search() {
        for(int i=0; i<students.size(); i++) {
            Student st = students.get(i);
            int x = st.x;
            int y = st.y;

            for(int j=0; j<4; j++) {
                int nx = x;
                int ny = y;

                while(true) {
                    nx += dx[j];
                    ny += dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                    if (map[nx][ny].equals("O")) break;

                    if (map[nx][ny].equals("T")) return false;
                }
            }
        }
        return true;
    }

    static class Student {

        int x;
        int y;

        public Student(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}

