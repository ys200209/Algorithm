import java.util.*;

class Main16_3 {
    public static int N, sum=0, result=0;
    public static int[] list;

    public static void main(String[] args) {

        // 백준 온라인 저지 Greedy(16)의 3번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        for(int i=0; i<N; i++) {
            sum += list[i];
            result += sum;
        }

        System.out.println(result);


    }
    
}
