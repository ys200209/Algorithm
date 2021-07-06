import java.util.*;

class Main6_4 {
    static int N, K;
    static Integer[] A, B;
    static int result;
    
    public static void main(String[] args) {
        
        /*
            X�� �� ���� �迭 A�� B�� ������ �ִ�. �� �迭�� N���� ���ҷ� �����Ǿ� ������, �迭�� ���Ҵ� ��� �ڿ����̴�.
            X�� �ִ� K���� �ٲ�ġ�� ������ ������ �� �ִµ�, 
            �ٲ�ġ�� �����̶� �迭 A�� �ִ� ���� �ϳ��� �迭 B�� �ִ� ���� �ϳ��� ��� �� ���Ҹ� ���� �ٲٴ� ���� ���Ѵ�.
            X�� ���� ��ǥ�� �迭 A�� ��� ������ ���� �ִ밡 �ǵ��� �ϴ� ���̸�, �������� X�� ���;� �Ѵ�.
            N, K, �׸��� �迭 A�� B�� ������ �־����� ��, �ִ� K���� �ٲ�ġ�� ������ �����Ͽ� ���� �� �ִ�
            �迭 A�� ��� ������ ���� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
            ex) N = 5, K = 3
            A = 1 2 5 4 3
            B = 5 5 6 6 5
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        A = new Integer[N];
        B = new Integer[N];
        
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i=0; i<N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i=0; i<K; i++) {
            if(A[i] >= B[i]) break;
            A[i] = B[i];
        }
        for(int i=0; i<N; i++) {
            result += A[i];
        }

        System.out.println("result = " + result);

    }

}
