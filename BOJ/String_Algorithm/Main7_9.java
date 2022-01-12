import java.io.*;
import java.util.*;

public class Main7_9 {
    static int result=0;
    static String str;
    static String[] spell = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        List<String> list = Arrays.asList(spell);
        visited = new boolean[str.length()];

        String s = "dz=ak";
        System.out.println(s.substring(3, 5));

        int i=2;
        while(!visited[str.length()-2]) {
            if (!visited[i-1]) {
                if (list.contains(str.substring(i-2, i-1))) {
                    result += 1;
                    visited[i-2] = true;
                } else if (list.contains(str.substring(i-2, i))) {
                    result += 1;
                    visited[i-2] = true;
                    visited[i-1] = true;
                } else if (list.contains(str.substring(i-2, i+1))) {
                    result += 1;
                    visited[i-2] = true;
                    visited[i-1] = true;
                    visited[i] = true;
                } else {
                    result += 1;
                    visited[i-2] = true;
                }
            }
            System.out.println(Arrays.toString(visited));
            
            i++;
        }

        //System.out.println(Arrays.toString(visited));

        result += visited[str.length()-1] ? 0 : 1;

        System.out.println(result);
    
    }
    
}
