import java.util.*;
import java.io.*;

public class Main16_10775 {
    static int G, P, result=0;
    static boolean[] gate;
    static int[] plain; 
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine()); // 비행기 라인마다 체크해주고 중복된 라인이 존재하면 라인 - 1을 체크해주는 식으로 카운트해본다
        gate = new boolean[G+1];
        plain = new int[P];

        for(int i=0; i<P; i++) {
            plain[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<P; i++) {
            DFS(0, 0);
        }

        System.out.println(result);

    }

    public static boolean DFS(int index, int count) {
        if (index == P-1) return true;

        for(int i=index; i<P; i++) {
            int empty=0;
            for(int j=plain[i]; j>0; j--) {
                if (!gate[j]) {
                    gate[j] = true;
                    result = Math.max(result, count+1);
                    if (DFS(i+1, count+1)) return true;
                } else empty++;
            }
            if (empty == plain[i]) return true;
        }

        return false;
    }

}