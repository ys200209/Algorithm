import java.util.*;
import java.io.*;

public class Main11_2309 {
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] A = new int[9];
    static StringBuilder sb = new StringBuilder();
    static boolean isSearch = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);

        System.out.println(sb);
    }

    public static void DFS(int i, int count) {
        if (count == 7) {
            int sum = 0;
            for(int j=0; j<7; j++) {
                sum += result.get(j);
            }

            if (sum == 100) {
                Collections.sort(result);
                for(int j=0; j<7; j++) {
                    sb.append(result.get(j) + "\n");
                }
                isSearch = true;
            }
            return;
        }

        for(int j=i; j<9; j++) {
            result.add(A[i]);
            DFS(j+1, count+1);
            if (isSearch) return;
            result.remove(result.size()-1);
        }
    }   
}