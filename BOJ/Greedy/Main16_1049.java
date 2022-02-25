import java.util.*;
import java.io.*;

public class Main16_1049 {
    static int N, M, pack=(int)1e9, per=(int)1e9, result=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            per = Math.min(per, Integer.parseInt(st.nextToken()));
        }

        while(N > 0) {
            if (N >= 6) {
                if (N*per > (N/6)*pack + (N%6)*per) {
                    result += (N/6*pack);
                    N %= 6;
                } else {
                    result += (N*per);
                    break;
                }
            } else {
                if (N*per > pack) result += pack;
                else result += (N*per);
                break;
            }
        }

        System.out.println(result);

    }

}