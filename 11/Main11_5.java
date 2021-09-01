import java.util.*;

class Main11_5 {
    static int N, M, result;
    static int[] list;
    
    public static void main(String[] args) {

        /*
            A, B 두 사람이 볼링을 치고 있습니다. 두 사람은 서로 무게가 다른 볼링공을 고르려고 한다.
            볼링공은 총 N개가 있고 각 볼링공마다 무게가 적혀 있고, 공의 번호는 1번부터 순서대로 부여된다.
            같은 무게의 공이 여러 개 있을 수 있다. 경우의 수를 구하라.
            16:33 -> 16:38(30분)
        */
    
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if (list[i] != list[j]) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    
    }

}
