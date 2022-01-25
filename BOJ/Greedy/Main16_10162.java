import java.util.*;

public class Main16_10162 {
    static int T;
    static int[] button, time = {300, 60, 10};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        if (T % 10 != 0) {
            System.out.println("-1");
            return;
        }

        button = new int[3];

        while(T > 0) {
            for(int i=0; i<3; i++) {
                button[i] = T / time[i];
                T %= time[i];
            }
        }

        for(int i=0; i<3; i++) {
            System.out.print(button[i] + " ");
        }
    }
}