import java.util.*;

public class Main8_3 {
    static int X, top, bottom=1;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();

        if (X == 1) {
            System.out.println("1/1");
            return;
        }

        int i=2;
        int num = 1;
        while(num + i < X) {
            num += i;
            i++;
        }

        top = X - num;
        bottom = i - (X - num - 1);

        if (i % 2 == 0) System.out.println(top + "/" + bottom);
        else System.out.println(bottom + "/" + top);
        
    }
}