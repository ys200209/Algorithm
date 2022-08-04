import java.util.*;
import java.io.*;

public class Main16_1080 {
    static int N, M, count=0;
    static boolean[][] arr1, arr2;
    
    public static void main(String[] args) throws IOException {

        init();

        for(int i=0; i<=N-3; i++) {
            for(int j=0; j<=M-3; j++) {
                if ((!arr1[i][j] && arr2[i][j]) || (arr1[i][j] && !arr2[i][j])) {
                    change(i, j);
                    count++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(count);
    }

    public static void change(int r, int c) {
        for(int i=r; i<r+3; i++) {
            for(int j=c; j<c+3; j++) {
                arr1[i][j] = !arr1[i][j];
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new boolean[N][M];
        arr2 = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String[] nums = br.readLine().split("");
            for(int j=0; j<nums.length; j++) {
                if (nums[j].equals("1")) arr1[i][j] = true;
            }
        }

        for(int i=0; i<N; i++) {
            String[] nums = br.readLine().split("");
            for(int j=0; j<nums.length; j++) {
                if (nums[j].equals("1")) arr2[i][j] = true;
            }
        }
    }

}
