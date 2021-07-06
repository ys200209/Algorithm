import java.util.*;

class Main6_2 {
    static int N;
    static Integer[] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        list = new Integer[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list, Collections.reverseOrder());

        System.out.println("list = " + Arrays.toString(list));

    }

}
