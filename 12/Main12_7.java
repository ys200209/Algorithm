import java.util.*;

class Main12_7 {
    static String[] N;
    static int front, back;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.next().split("");
        front = 0;
        back = 0;

        for (int i=0; i<N.length/2; i++) {
            front += Integer.parseInt(N[i]);
        }
        for(int i=N.length/2; i<N.length; i++) {
            back += Integer.parseInt(N[i]);
        }

        if (front == back) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}
