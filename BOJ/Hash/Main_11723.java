import java.util.*;
import java.io.*;

public class Main_11723 {
    static int M, num;
    static String command;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            command = st.nextToken();
            if (command.equals("all")) {
                set.clear();
                for(int j=1; j<=20; j++) {
                    set.add(j);
                }
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }

            num = Integer.parseInt(st.nextToken());

            if (command.equals("add")) set.add(num);
            else if (command.equals("remove")) set.remove(num);
            else if (command.equals("check")) {
                if (set.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            } else if (command.equals("toggle")) {
                if (set.contains(num)) set.remove(num);
                else set.add(num);
            } 

        }

        System.out.println(sb);
        

    }

}
