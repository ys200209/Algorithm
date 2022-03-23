import java.util.*;
import java.io.*;

public class Main21_12738 {
    static int N;
    static int[] A;
    static ArrayList<Integer> result = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            binary_Search(0, result.size(), A[i]);
            i++;
        }

        for(int n : result) {
            System.out.println(n);
        }

        System.out.println(result.size());

    }

    public static void binary_Search(int start, int end, int target) {
        if (start >= end) {
            result.add(target);
            return;
        }

        int mid = (start + end) / 2;
        if (result.get(mid) < target) {
            binary_Search(mid+1, end, target);
        } else if (result.get(mid) > target) {
            binary_Search(start, mid, target);
        } else return;
    }

}
