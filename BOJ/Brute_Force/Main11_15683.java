import java.util.*;
import java.io.*;

public class Main11_15683 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] board;
    static CCTV cctv = new CCTV();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cctv.cctv1.add(new CCTV1(i, j, 0));
                if (board[i][j] == 2) cctv.cctv2.add(new CCTV2(i, j, 0));
                if (board[i][j] == 3) cctv.cctv3.add(new CCTV3(i, j, 0));
                if (board[i][j] == 4) cctv.cctv4.add(new CCTV4(i, j, 0));
                if (board[i][j] == 5) cctv.cctv5.add(new CCTV5(i, j, 0));
                j++;
            }
        }
        

        System.out.println("(1) size : " + cctv.cctv1.size());
        System.out.println("(2) size : " + cctv.cctv2.size());
        System.out.println("(3) size : " + cctv.cctv3.size());
        System.out.println("(4) size : " + cctv.cctv4.size());
        System.out.println("(5) size : " + cctv.cctv5.size());

        


    }

}

class CCTV {

    ArrayList<CCTV1> cctv1;
    ArrayList<CCTV2> cctv2;
    ArrayList<CCTV3> cctv3;
    ArrayList<CCTV4> cctv4;
    ArrayList<CCTV5> cctv5;

    public CCTV() {
        this.cctv1 = new ArrayList<>();
        this.cctv2 = new ArrayList<>();
        this.cctv3 = new ArrayList<>();
        this.cctv4 = new ArrayList<>();
        this.cctv5 = new ArrayList<>();
    }

}

class CCTV1 {

    int x, y, vector, vectorCount = 1;

    public CCTV1(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }

}

class CCTV2 {

    int x, y, vector, vectorCount = 2;

    public CCTV2(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }

}

class CCTV3 {

    int x, y, vector, vectorCount = 2;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public CCTV3(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }
    
}

class CCTV4 {

    int x, y, vector, vectorCount = 3;

    public CCTV4(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }
    
}

class CCTV5 {

    int x, y, vector, vectorCount = 4;

    public CCTV5(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }
    
}