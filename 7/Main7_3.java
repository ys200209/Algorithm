import java.util.*;

class Main7_3 {
    static int N, M, H;
    static int[] list;
    //static int start, end, mid;

    public static void main(String[] args) {

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

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new int[N];
        
        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        System.out.println("list = " + Arrays.toString(list));
        int result = binarySearch(list, M, list[0], list[N-1]);

        System.out.println("result = " + result);

    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        
        int mid = (start+end) / 2;
        int sum = 0;
        

        for(int i=0; i<arr.length; i++) {
            sum += arr[i] > mid ? arr[i]-mid : 0;
        }   
        if (sum > M) { // 9 > 7
            return binarySearch(arr, target, mid+1, end); // 일치값이 존재하지 않을 경우 해당 함수와
        } else if (sum < M) {
            return binarySearch(arr, target, start, mid-1); // 아래 함수가 서로 무한 반복되며 수행될 가능성
        } else if (sum == M) {
            return mid;
        }

        return -1;
    }

}
