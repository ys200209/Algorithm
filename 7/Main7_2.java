import java.util.*;

class Main7_2 {
    static int N, M, result;
    static int[] N_List, M_List;
    static String str = "";
    
    public static void main(String[] args) {

        /* 
            A의 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 어느 날 손님이
            M개 종류의 부품을 대량으로 구매하겠다며 견적서를 요청했다. A의 가게에 손님이 문의한 부품이 모두 있는지
            확인하는 프로그램을 작성하라.
            ex) 
            N = 5
            [8, 3, 7, 9, 2]
            M = 3
            [5, 7, 9]
            -> no yes yes
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        N_List = new int[1000001];
        for(int i=0; i<N; i++) {
            N_List[i] = sc.nextInt();
        }

        M = sc.nextInt();
        M_List = new int[M];
        for(int i=0; i<M; i++) {
            M_List[i] = sc.nextInt();
        }

        Arrays.sort(N_List);
        Arrays.sort(M_List);

        for(int i=0; i<M; i++) {
            System.out.println("i = " + i);
            System.out.println("N_List[M_List[i]] = " + N_List[M_List[i]]);
        }

        System.out.println(str);

    }

}
