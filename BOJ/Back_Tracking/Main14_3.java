import java.util.*;

public class Main14_3 {
    static int N, M;
    static int[] A;
    static String str="";
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        A = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = i+1;
        }

        DFS(0);

        System.out.println(sb);
    }

    public static void DFS(int count) {
        if (count == M) {
            sb.append(str + "\n");
            return;
        }

        for(int i=0; i<N; i++) {
            str += A[i] + " ";
            count += 1;
            DFS(count);
            count -= 1;
            str = str.substring(0, str.length()-2);
        }


    }
    
}
