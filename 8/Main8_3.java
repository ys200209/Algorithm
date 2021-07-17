import java.util.*;

class Main8_3 {
    static int N;
    static int[] list;
    public static void main(String[] args) {

        /*
            4
            1 3 1 5
        */

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        for(int i=0; i<N-3; i+=2) {
            if(list[0]+list[1] > list[1]+list[2]) {
                
            }
        }

    }

}
