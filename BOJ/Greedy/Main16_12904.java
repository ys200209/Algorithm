import java.util.*;
import java.io.*;

public class Main16_12904 {
    static String S, T;
    static Deque<String> deque = new ArrayDeque<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        T = br.readLine();

        int lenS = S.length();
        int lenT = T.length();

        while(lenS < lenT) {
            


            lenS++;
        }


        StringBuilder sb = new StringBuilder();


        System.out.println(sb);
    }
}