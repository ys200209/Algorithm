import java.util.*;

class Main3 {

    public static void main(String[] args) {
        int min = 9;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        //int[] list = new int[M];
        
        for(int i=0; i<N; i++) {
            min = 9;
            for(int j=0; j<M; j++) {
                min = Math.min(min, sc.nextInt());
            }
            max = Math.max(max, min);
            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }
        
        System.out.println("최종값 : " + max);
        sc.close();
    }

}
