import java.util.*;

public class Main20_2 {
    static int N;
    static String[][] video;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        video = new String[N][N];

        for(int i=0; i<N; i++) {
            video[i] = scanner.next().split("");
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(video[i]));
        }

        divide(0, 0, N);

        System.out.println(sb);
    }

    public static void divide(int row, int column, int size) {
        if (BlackAndWhite(row, column, size)) {
            sb.append(video[row][column]);
            return;
        }

        sb.append("(");
        size /= 2;
        divide(row, column, size);
        divide(row, column+size, size);
        divide(row+size, column, size);
        divide(row+size, column+size, size);
        sb.append(")");
    }

    public static boolean BlackAndWhite(int row, int column, int size) {
        String color = video[row][column];

        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if (!video[i][j].equals(color)) return false;
            }
        }
        return true;
    }

}