import java.util.*;
import java.io.*;

public class Main16_12904 {
    static String S, T;
    static Deque<String> deque = new ArrayDeque<>();
    static boolean isA = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        T = br.readLine();

        int start = 0;
        int index = 0;
        while(!(S.length() == T.length())) {
        // for(int i=0; i<6; i++) {
            index = T.substring(start, T.length()).indexOf(S);
            // System.out.println(start + " ~ " + T.length() + ", '" + S + "' = " + "index : " + index);

            if (index == -1) {
                if (isA) S = "B" + S;
                else S += "B";

                isA = !isA;
                start = 0;
                continue;
            }

            if (isA) {
                if (T.length() <= start + index + S.length()) {
                    isA = !isA;
                    start = 0;
                    S = "B" + S;
                    continue;
                } 

                if (T.charAt(start + index + S.length()) == 'A') S += "A";
                else start = (start+index+1);
            } else {
                if (index-1 < 0) {
                    isA = !isA;
                    start = 0;  
                    continue;
                }

                if (T.charAt(index-1) == 'A') S = "A" + S;
                else {
                    S += "B";
                    isA = !isA;
                    start = 0;
                }
            }
        }
        
        System.out.println(S.equals(T) ? 1 : 0);

    }
}