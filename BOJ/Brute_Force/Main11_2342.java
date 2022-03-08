import java.util.*;
import java.io.*;

public class Main11_2342 {
    static int result=0;
    static int[] A;
    static ArrayList<Position>[] dp;
    
    public static void main(String[] args) throws IOException {

        dp = new ArrayList<>[2]; // [0] : 왼발, [1] : 오른발
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int i=0;
        while(st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            if (target == 0) break;

            Position position;

            if (target == 1) position = new Position(0, 1, 2);
            else if (target == 2) position = new Position(1, 0, 2);
            else if (target == 3) position = new Position(2, 1, 2);
            else position = new Position(1, 2, 2);

            Move(i, position);
            i++;
        }

        System.out.println(result);

    }

    public static void Move(int i, Position position) {
        if (i == 0) {
            dp[0].add(position);
            dp[1].add(position);
        } else {
            Position leftStep = dp[0].get(i-1);
            Position rightStep = dp[1].get(i-1);

            int leftCost = Math.abs(leftStep.left - position.left) + Math.abs(leftStep.right - position.right);
            int rightCost = Math.abs(rightStep.left - position.left) + Math.abs(rightStep.right - position.right);

            if (leftCost + rightCost == 0) { // 제자리 클릭

            } else { // 인접한 방향인지, 대칭된 위치인지
                
            }

        }


    }

}

class Position {

    int left;
    int right;
    int cost;

    public Position(int left, int right, int cost) {
        this.left = left;
        this.right = right;
        this.cost = cost;
    }    

}