import java.util.*;
import java.io.*;

public class Main15_14 {
    static int result=0;
    static String temp1, temp2, str="";
    static String[] A, B;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        temp1 = br.readLine();
        temp2 = br.readLine();
        if (temp1.length() >= temp2.length()) { // 더 긴 문자열을 A에 담도록.
            A = temp1.split("");
            B = temp2.split("");
        } else {
            A = temp2.split("");
            B = temp1.split("");
        }
        
        visited = new boolean[B.length];
        DFS(0, 0);
        visited = new boolean[B.length];
        str = "";
        search(0, 0);

        System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count == B.length) return;

        for(int i=index; i<B.length; i++) {
            for(int j=i; j<B.length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    str += B[j];
                    count += 1;
                    set.add(str);
                    DFS(j, count);
                    count -= 1;
                    str = str.substring(0, str.length()-1);
                    visited[j] = false;
                } 
            }
        }
    }

    public static void search(int index, int count) {
        if (count == B.length) return;

        for(int i=index; i<A.length; i++) {
            for(int j=i; j<A.length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    str += A[j];
                    count += 1;
                    result = set.contains(str) ? Math.max(str.length(), result) : result;
                    search(j, count);
                    count -= 1;
                    str = str.substring(0, str.length()-1);
                    visited[j] = false;
                } 
            }
        }
    }

}