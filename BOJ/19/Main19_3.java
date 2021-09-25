import java.util.*;

class Main19_3 {
    public static int N, K, index, count;
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 큐, 덱(19)의 3번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        index = 0;
        count = 0;
       
        for(int i=1; i<=N; i++) {
            while(true) {
                count += 1;
                index += 1;

                if (index > N) {
                    index = 0;
                }
                
                if (count % K == 0) {
                    q.add(index);
                    count = 0;
                    break;
                }
            }
        }

        System.out.println(q);
    }

}
