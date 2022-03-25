import java.util.*;
import java.io.*;

public class Main38_14268 {
    static int N, M;
    static int[] list, tree, lazy;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.readLine();
        list = new int[N+1];
        tree = new int[N*4];
        lazy = new int[N*4];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            if (command == 1) { // A번째 직원이 직속 상사로부터 칭찬을 받음 (list 배열을 만들어서)
                                // list[A] 이하의 숫자들을 업데이트 하는 방식으로 구현
                int B = Integer.parseInt(st.nextToken());
                Update(1, N, 1, A, N, B);
            } else {
                sb.append(Query(1, N, 1, A) + "\n");
            }
        }
        System.out.println(Arrays.toString(tree));
        System.out.println(Arrays.toString(lazy));
        System.out.println(sb);
    }

    public static int Query(int start, int end, int node, int index) {
        lazy_Update(start, end, node);

        if (start > index || end < index) return 0;

        if (start == index && end == index) return tree[node];

        int mid = (start + end) / 2;
        return Query(start, mid, node*2, index) + Query(mid+1, end, node*2+1, index);
    }

    public static int Update(int start, int end, int node, int left, int right, int change) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return tree[node];

        if (start >= left && end <= right) {
            lazy[node] += change;

            lazy_Update(start, end, node);

            return tree[node];
        }

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, left, right, change) + Update(mid+1, end, node*2+1, left, right, change);
    }

    public static void lazy_Update(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

}