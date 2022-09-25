package KAKAO_BLIND_RECRUITMENT.Kakao2023;

public class MainKakao2023_2 {
    static int distance = (int)1e9, deliveryAmount=0, pickupAmount=0;
    static int N, Cap; /// 삭제
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        // 16

    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        N = n;
        Cap = cap;

        for (int delivery : deliveries) {
            deliveryAmount += delivery;
        }
        for (int pickup : pickups) {
            pickupAmount += pickup;
        }

        BottomUp(1, 0, deliveries, pickups);

        for(int i=1; i<=cap; i++) {
            TopDown(n, i);
        }

        dp = new int[n+1][cap+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=cap; j++) {
//                dp[i][j] =
            }
        }


        System.out.println("distance = " + distance);

        return distance;
    }

    // index와 cap을 전달받고 해당 위치에서 갈 수 있는 최대 거리만큼을 진행하는 메서드 모듈을 생성하자.



    private static void BottomUp(int index, int dis, int[] deliveries, int[] pickups) {
        if (index > N) {
            distance = Math.min(distance, dis);
            return;
        }

        System.out.println("index = " + index + ", dis : " + dis);

        int[] copyDeliveries = copyArr(deliveries);
        int[] copyPickups = copyArr(pickups);

        for(int i=1; i<=Cap; i++) {
            int nextIndex = go(index, i, copyDeliveries, copyPickups, true);
            System.out.println("cap = " + i + ", nextIndex : " + nextIndex);
            if (nextIndex > N) { // 다음으로 이동할 필요가 없다면 (인덱스가 중간에서 시작해도 뒤에 택배나 픽업이 없으면)
                distance = Math.min(distance, dis);
                return;
            }
            int d = getDistance(index, nextIndex);
            BottomUp(nextIndex, dis + d, copyDeliveries, copyPickups);
        }
    }

    private static int go(int index, int cap, int[] deliveries, int[] pickups, boolean isBottomUp) {
        int pickupCount = 0; // 돌아가면서 픽업해야할 상자 수
        int nowIndex = index;
        int nowBox = cap; // 현재 들고 있는 택배 수
        boolean isExist = false; // 현재 위치로부터 다음 위치로 이동하는 사이에 택배가 존재 하였는가?
        while(nowBox > 0) {
            if (nowIndex < 1 || nowIndex >= N) break;

            if (deliveries[nowIndex] != 0 || pickups[index] != 0) isExist = true;

            if (nowBox - deliveries[nowIndex] < 0) deliveries[nowIndex] -= nowBox; // 현재 가지고 있는 택배보다 더 많은 택배를 원하면 (복귀)
            else nowBox -= deliveries[nowIndex]; // 택배를 다 줄 수 있다면

            if (nowBox + pickups[nowIndex] + pickupCount > cap) {
                pickups[nowIndex] -= (cap-pickupCount-nowBox); // 복귀하며 가져가야 할 상자와 현재 가져갈 상자가 cap을 초과한다면
                break;
            }
            else pickupCount += pickups[nowIndex]; // 그냥 상자를 가져갈 수 있다면

            nowIndex = isBottomUp ? nowIndex+1 : nowIndex-1;
        }

        return isExist ? nowIndex : index; // 다른 손님?이 존재 했으면 다음 위치로, 아니라면 초기 위치로 복귀
    }

    private static int[] copyArr(int[] arr) {
        int[] temp = new int[arr.length];

        for(int i=0; i<temp.length; i++) {
            temp[i] = arr[i];
        }

        return temp;
    }

    private static int getDistance(int index, int nextIndex) {
        return (nextIndex < 1 || nextIndex >= N) ? Math.abs(nextIndex - index) : index + nextIndex;
    }




    private static void TopDown(int n, int cap) {

    }

}