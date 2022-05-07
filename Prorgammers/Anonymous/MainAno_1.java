import java.util.*;

class MainAno_1 {
    static int result=0;
    static boolean[] prime = new boolean[3000];

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,2,7,6,4})); // 4
        
    }
    
    public static int solution(int[] nums) {
        checkPrime();

        DFS(0, nums, 0, 0);

        return result;
    }

    public static void checkPrime() {

        for(int i=2; i<1500; i++) {
            if (!prime[i]) {
                for(int j=i*2; j<3000; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static void DFS(int index, int[] nums, int sum, int count) {
        if (count == 3) {
            if (!prime[sum]) result++;
            return;
        }

        for(int i=index; i<nums.length; i++) {
            sum += nums[i];
            DFS(i+1, nums, sum, count+1);
            sum -= nums[i];
        }
    }

}