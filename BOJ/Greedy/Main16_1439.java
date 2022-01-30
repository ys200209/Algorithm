import java.util.*;

public class Main16_1439 {
    static int result1=0, result2=0;
    static String S;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        S = scanner.nextLine();

        char c = S.charAt(0);
         
        for(int i=1; i<S.length(); i++) {
            if (c == '1' && S.charAt(i) == '0') result1++; // 1 To 0
            else if (c == '0' && S.charAt(i) == '1') result2++; // 0 To 1
            
            c = S.charAt(i);
        }

        if (S.charAt(S.length()-1) == '1') result1++;
        else if (S.charAt(S.length()-1) == '0') result2++;

        System.out.println(Math.min(result1, result2));

    }
}
