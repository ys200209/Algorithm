import java.util.*;

class Main12_7 {
    static int N, front=0, back=0;
    static String[] str;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        str = Integer.toString(N).split("");

        for(int i=0; i <str.length; i++) {
            if (i < str.length/2) {
                front += Integer.parseInt(str[i]);
            } else {
                back += Integer.parseInt(str[i]);
            }
        }

        if (front == back) System.out.println("LUCKY");
        else System.out.println("READY");

    }

}