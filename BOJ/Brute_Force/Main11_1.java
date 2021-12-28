import java.util.*;

public class Main11_1 {
    public static int N, M, max_value=0, d=0;
    public static boolean[] visited;
    public static int[] list;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        visited = new boolean[N];
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        search(0);

        System.out.println(max_value);

    }

    public static void search(int count) {
        if (count == 3) {
            if (d <= M && d > max_value) {
                max_value = d;
            }
            return;
        }

        for(int i=0; i<N; i++) {
            if (visited[i] == false) {
                d += list[i];
                visited[i] = true;
                count += 1;
                search(count);
                count -= 1;
                visited[i] = false;
                d -= list[i];
            }
        }
    }
}
