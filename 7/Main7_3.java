import java.util.*;

class Main7_3 {
    static int N, M, H;
    static int[] list;
    //static int start, end, mid;

    public static void main(String[] args) {

        /*
            A�� ������ ��ϰ� ������ A�� ������ ���� ���̰� �������� �ʴ�. ��ſ� �� ���� �ȿ� ���� ����
            �� ���̴� ���ܱ�� �߶� �����ش�.
            ���ܱ⿡ ����(H)�� �����ϸ� �������� ���� �� ���� �����Ѵ�. ���̰� H���� �� ���� H ���� �κ��� �߸� ���̰�,
            ���� ���� �߸��� �ʴ´�.
            ���� ���̰� 19, 14, 10, 17cm�� ���� ������ �ְ� ���ܱ� ���̸� 15cm�� �����ϸ� �߸� ���� ���̴� ���ʴ��
            4, 0, 0, 2cm�̴�. �մ��� 6cm��ŭ�� ���̸� ��������.
            �մ��� ���� �� ��û�� �� ���̰� M�� �� ��� M��ŭ�� ���� ��� ���� ���ܱ⿡ ������ �� �ִ�
            ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
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
            return binarySearch(arr, target, mid+1, end); // ��ġ���� �������� ���� ��� �ش� �Լ���
        } else if (sum < M) {
            return binarySearch(arr, target, start, mid-1); // �Ʒ� �Լ��� ���� ���� �ݺ��Ǹ� ����� ���ɼ�
        } else if (sum == M) {
            return mid;
        }

        return -1;
    }

}
