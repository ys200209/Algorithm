import java.util.*;

class Main13_19 {
    static int N, MAX=-1000000000, MIN=1000000000, result;
    static int[] N_list, C_list;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        N_list = new int[N];
        C_list = new int[4];

        for(int i=0; i<N; i++) {
            N_list[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++) {
            C_list[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(N_list));
        System.out.println(Arrays.toString(C_list));

        for(int i=0; i<4; i++) {
            if(C_list[i] != 0) {
                System.out.println("C_list["+i+"] != 0");
                BFS(C_list, i, 1, N_list[0]);
            }
        }

        System.out.println("MAX = " + MAX);
        System.out.println("MIN = " + MIN);

    }

    public static int BFS(int[] list, int C_index, int count, int result) {
        System.out.println("(into) count = " + count);
        System.out.println("(into) result = " + result);
        if (list[C_index] <= 0) {
            return -1;
        }
        if(count >= N) {
            MAX = Math.max(result, MAX);
            MIN = Math.min(result, MIN);
            return result;
        }
        
        if(C_index >= 4) {
            C_index -= 4;
        }
        list[C_index%4] -= 1;

        System.out.println("list = " + Arrays.toString(list));
        
        BFS(list, C_index+1, count+1, result+N_list[count]);
        BFS(list, C_index+1, count+1, result-N_list[count]);
        BFS(list, C_index+1, count+1, result*N_list[count]);
        BFS(list, C_index+1, count+1, result/N_list[count]);

        return -1;
        
    }

}
