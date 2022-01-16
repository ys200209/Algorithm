import java.util.*;

public class Main14_2 {
    static int N, M;
    static String str="";
    static int[] A;
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

        DFS(0, 0);

        System.out.println(sb);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            sb.append(str + "\n");
        }

        for(int i=index; i<N; i++) {
            if (!visited[i]) {
                str += A[i] + " ";
                visited[i] = true;
                count += 1;
                DFS(i, count);
                count -= 1;
                visited[i] = false;
                str = str.substring(0, str.length() - 2);
            }
        }


    }
    
}
