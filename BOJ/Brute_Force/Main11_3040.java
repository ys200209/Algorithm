import java.util.*;
import java.io.*;

public class Main11_3040 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] select = new int[7];
    static boolean[] visited = new boolean[9];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        DFS(0, 0);
    }

    public static void DFS(int index, int count) {
        if (count == 7) {
            int sum=0;

            for(int num : select) sum += num;

            if (sum == 100) {
                for(int num : select) sb.append(num + "\n");

                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for(int i=index; i<9; i++) {
            select[count] = list.get(i);
            DFS(i+1, count+1);
            select[count] = 0;
        }
    }

}
