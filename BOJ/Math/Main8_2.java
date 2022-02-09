import java.util.*;

public class Main8_2 {
    static int N, result=0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        int num = 1;
        int i=1;
        while(num < N) {
            num += (6 * i);
            i++;
        }

        System.out.println(i);

    }
}
