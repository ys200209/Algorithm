import java.util.*;

class Main11_2 {
    static String[] S;
    static String[] arr;
    static int num, total;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        S = scanner.next().split("");
        total = Integer.parseInt(S[0]);
        
        for(int i=1; i<S.length; i++) {
            if( total == 0 || total == 1 || Integer.parseInt(S[i]) == 0 || Integer.parseInt(S[i]) == 1) {
                total += Integer.parseInt(S[i]);
            } else {
                total *= Integer.parseInt(S[i]);
            }
        }

        System.out.println(total);

    }

}