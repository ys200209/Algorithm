import java.util.*;
import java.io.*;

public class Main15_12015 {
    static int N;
    static int[] A;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        if (N==1) {
			sb.append("1\n"+A[1]);
			System.out.println(sb);
			return;
		}

        list.add(A[1]);

        for(i=2; i<=N; i++) {
            if (list.get(list.size()-1) < A[i]) {
                list.add(A[i]);
            } else {
                lowerBound(A[i], 0, list.size()-1);
            }
        }

        System.out.println(list.size());
    }

    public static void lowerBound(int num, int start, int end) {
        if (start > end) {
            list.set(start, num);
            return;
        }

        int mid = (start + end) / 2;

        if (list.get(mid) < num) {
            lowerBound(num, mid+1, end);
        } else if (list.get(mid) > num) {
            lowerBound(num, start, mid-1);
        }
    }
}