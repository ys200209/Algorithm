import java.util.*;
import java.io.*;

public class Main_14891 {
    static int K, result=0;
    static String[] list = new String[4];
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++) {
            list[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        for(int k=0; k<K; k++) {
            visited = new boolean[4];
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            DFS(number-1, d);
        }

        for(int i=0; i<4; i++) {
            result += (list[i].charAt(0) - '0') == 0 ? 0 : Math.pow(2, i);
        }

        System.out.println(result);
    }   

    public static void DFS(int number, int d) { // 2 or 6
        if (number < 0 || number > 3 || visited[number]) return;
        visited[number] = true;

        if (number-1 >= 0 && list[number].charAt(6) != list[number-1].charAt(2)) DFS(number-1, d * (-1));
        if (number+1 <= 3 && list[number].charAt(2) != list[number+1].charAt(6)) DFS(number+1, d * (-1));

        if (d == 1) {
            list[number] = list[number].substring(7, 8) + list[number].substring(0, 7);
        } else {
            list[number] = list[number].substring(1, 8) + list[number].substring(0, 1);
        }
    }

}