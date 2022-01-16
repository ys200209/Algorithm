import java.util.*;

public class Main14_4 {
    static int N, M;
    static int[] A;
    static String str="";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        A = new int[N];
        
        for(int i=0; i<N; i++) {
            A[i] = i+1;
        }

        DFS(0, 0);

        System.out.println(sb);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            sb.append(str + "\n");
            return;
        }

        for(int i=index; i<N; i++) {
            str += A[i] + " ";
            count += 1;
            DFS(i, count);
            count -= 1;
            str = str.substring(0, str.length()-2);
        }
    }
    
}
