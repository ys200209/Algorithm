import java.io.*;
import java.util.StringTokenizer;

public class Main11_1476 {
    static int count=0, result=1;
    static int[] years, now;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        years = new int[3];
        now = new int[3];

        for(int i=0; i<3; i++) {
            years[i] = Integer.parseInt(st.nextToken());
            now[i] = 1;
        }

        while(true) {
            count=0;
            for(int i=0; i<3; i++) {
                if (years[i] != now[i]) {
                    now[0] = now[0] == 15 ? 1 : now[0] + 1;
                    now[1] = now[1] == 28 ? 1 : now[1] + 1;
                    now[2] = now[2] == 19 ? 1 : now[2] + 1;
                    result++;
                    break;
                }
                count++;
            }
            
            if (count == 3) break;
        }

        System.out.println(result);

    }
}