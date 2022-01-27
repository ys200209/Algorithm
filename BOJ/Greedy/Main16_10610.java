import java.util.*;

public class Main16_10610 {
    static int result=0;
    static String number="";
    static String[] N;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        N = Integer.toString(scanner.nextInt()).split("");
        visited = new boolean[N.length];

        DFS(0);

        if (result == 0) System.out.println("-1");
        else System.out.println(result);
        
    }

}