import java.util.*;

class Main11_2 {
    public static int result=0;
    public static String S;
    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        S = scanner.nextLine();

        int result = S.charAt(0) - '0';

        for(int i=1; i<S.length(); i++) {
            if (S.charAt(i) - '0' <= 1 || result <= 1) {
                result += S.charAt(i) - '0';
            } else {
                result *= S.charAt(i) - '0';
            }
        }

        System.out.println(result);
        
    }

}