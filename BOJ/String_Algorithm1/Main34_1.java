import java.util.*;

public class Main34_1 {
    static int checkPoint=0, count=0, index;
    static String T, P;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb_T = new StringBuilder();
    static StringBuilder sb_P = new StringBuilder();

    public static void main(String[] args) {

        T = br.readLine();
        P = br.readLine();



        while(true) {
            index = T.substring(checkPoint, T.length()).indexOf(P);

            if (index == -1) break;

            count += 1;
            sb_P.append(index + " ");
            checkPoint = index;
        }



    }
    
}
