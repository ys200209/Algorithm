import java.util.*;
import java.io.*;

class Main7_3 {
    static int N, M, MIN, MAX, slice, result=0;
    static int[] A;


    public static void main(String[] args) throws IOException {

        /*
            A는 떡집을 운영하고 있으며 A네 떡볶이 떡은 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는 떡의
            총 길이는 절단기로 잘라서 맞춰준다.
            절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고,
            낮은 떡은 잘리지 않는다.
            예로 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 잘린 떡의 길이는 차례대로
            4, 0, 0, 2cm이다. 손님은 6cm만큼의 길이를 가져간다.
            손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는
            높이의 최댓값을 구하는 프로그램을 작성하시오
            ex)
            N = 4, M = 6 (1<= N <=1,000,000, 1<= M <=2,000,000,000)
            19 15 10 17
            -> 15
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        MAX = A[A.length-1];

        binarySearch(M, 0, MAX);

        System.out.println(result);



    }

    public static void binarySearch(int target, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;
        slice = 0;
        for(int j=0; j<N; j++) {
            slice += A[j] - mid < 0 ? 0 : A[j] - mid;
        }

        if (target > slice) {
            binarySearch(target, front, mid-1);
        } else {
            result = mid;
            binarySearch(target, mid+1, back);
        }

    }

}