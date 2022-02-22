import java.util.*;
import java.io.*;

public class Main_2002 {
    static int N, result=0;
    static ArrayList<String> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cars = new boolean[N];

        for(int i=0; i<N; i++) {
            list.add(br.readLine());
        }
        
        for(int i=0; i<N; i++) {
            String name = br.readLine();

            if (list.get(0).equals(name)) {
                list.remove(0);
            } else {
                result++;
                list.remove(list.indexOf(name));
            }
        }
        
        System.out.println(result);

    }
    
}