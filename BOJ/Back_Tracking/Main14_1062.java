import java.util.*;
import java.io.*;

public class Main14_1062 {
    static Map<Integer, Integer> xMap = new HashMap<>();
    static Map<Integer, Integer> yMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int[] nums = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine(), " " );

            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
            nums[2] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(nums);

            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) break;

            sb.append(Math.pow(nums[2], 2) == Math.pow(nums[0], 2) + Math.pow(nums[1], 2) ? "right\n" : "wrong\n");
        }

        System.out.println(sb);
    }
}