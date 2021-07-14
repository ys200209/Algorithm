import java.util.*;

class Main11_1 {
    static int N, index1, index2, result = 0;
    static int[] list;

    public static void main(String[] args) {

        /*
            모험가가 N명 있다. N명의 모험가를 대상으로 '공포도'를 측정했는데, '공포도'가 높은 모험가는 쉽게 공포를 느껴
            위험 상황에서 제대로 대처할 능력이 떨어진다. 구성원을 안전하게 구성하고자 
            공포도가 X인 모험가는 반드시 X명 이상으로 구성한 그룹에 참여해야 한다고 규정했다. 
            N명의 모험가에 대한 정보가 주어졌을 때, 최대 몇 개의 그룹을 만들 수 있는지 구하는 프로그램을 작성하시오.
            ex)
            N = 5일 때
            공포도가 2 3 1 2 2라면 최대 2개의 그룹을 만들 수 있다.
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);

        index2 = index1 + list[index1] - 1;
        while(true) {
            if (index2 >= list.length) {
                break;
            }
            if (index2-index1+1 == list[index2]) {
                result++;
                if(index2 != list.length-1) { // 그룹을 묶고도 아직 길드원이 더 남았다면 index를 넘기는 과정.
                    index1 = index2+1;
                    index2 = index1 + list[index1] - 1;
                } else { // 그룹을 묶었는데 마지막 인원까지 묶어서 index를 다음 길드원으로 넘길 수 없을 때.
                    break;
                }
            } else {
                index2++;
            }
        }
        System.out.println("result = " + result);
    }
    
}
