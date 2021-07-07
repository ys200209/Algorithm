import java.util.*;

class Main7_2 {
    static int N, M, result;
    static int[] N_List, M_List;
    static String str = "";
    
    public static void main(String[] args) {

        /* 
            A�� ���� ���忡�� ��ǰ�� N�� �ִ�. �� ��ǰ�� ���� ������ ������ ��ȣ�� �ִ�. ��� �� �մ���
            M�� ������ ��ǰ�� �뷮���� �����ϰڴٸ� �������� ��û�ߴ�. A�� ���Կ� �մ��� ������ ��ǰ�� ��� �ִ���
            Ȯ���ϴ� ���α׷��� �ۼ��϶�.
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
