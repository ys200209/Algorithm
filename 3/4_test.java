import java.util.*;

class Main3_4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();

        while(N > 1) {
            if (N % K == 0) {
                N /= K;
            } else {
                N -= 1;
            }
            count++;
        }
        System.out.println("count : " + count);
    }

}
