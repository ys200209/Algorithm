import java.util.*;

class Main12_7 {
    static int N, mid, front, back;
    static String str;
    static int[] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        mid = str.length()/2;
        list = new int[str.length()];

        for(int i=0; i<str.length(); i++) {
            list[i] = str.charAt(i) - '0';
        }

        for(int i=0; i<mid; i++) {
            front += list[i];
        }
        for(int i=mid; i<str.length(); i++) {
            back += list[i];
        }

        if(front == back) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
    
}
