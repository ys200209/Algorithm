import java.util.*;

class Main8_3 {
    public static int N, max;
    public static int[] store, d;
    public static boolean[] visited;

    public static void main(String[] args) {

        /*
            4
            1 3 1 5 7 1 8 2
        */
        
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        store = new int[N];
        visited = new boolean[N];
        d = new int[100];

        for(int i=0; i<N; i++) {
            store[i] = scanner.nextInt();
        }

        dynamic(store);

        System.out.println("max = " + d[N-1]);
        System.out.println(Arrays.toString(d));

    }

    public static void dynamic(int[] store) {
        d[0] = store[0];
        d[1] = Math.max(store[0], store[1]);

        for(int i=2; i<store.length; i++) {
            System.out.println("d["+i+"+1] = " + d[i+1]);
            d[i] = Math.max(d[i-2]+store[i], d[i+1]);
        }
    }

}
