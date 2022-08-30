import java.util.*;
import java.io.*;

public class Main38_18436 {
    static int N, M;
    static int[] list;
    static Number[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        tree = new Number[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            list[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (command == 1) {
                Update(1, N, 1, A, B);
            } else if (command == 2) {
                sb.append(Query(1, N, 1, A, B).two + "\n");
            } else {
                sb.append(Query(1, N, 1, A, B).three + "\n");
            }
        }
        System.out.println(sb);
    }

    public static Number init(int start, int end, int node) {
        if (start == end) return tree[node] = list[start] % 2 == 0 ? new Number(1, 0) : new Number(0, 1);

        int mid = (start + end) / 2;
        Number number1 = init(start, mid, node*2);
        Number number2 = init(mid+1, end, node*2+1);
        
        return tree[node] = new Number(number1.two + number2.two, number1.three + number2.three);
    }

    public static Number Query(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return null;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        Number number1 = Query(start, mid, node*2, left, right);
        Number number2 = Query(mid+1, end, node*2+1, left, right);
        if (number1 == null) return number2;
        else if (number2 == null) return number1;
        else {
            return new Number(number1.two + number2.two, number1.three + number2.three);
        }
    }   

    public static Number Update(int start, int end, int node, int index, int change) {
        if (start > index || end < index) return tree[node];

        if (start == index && end == index) return tree[node] = change % 2 == 0 ? new Number(1, 0) : new Number(0, 1);

        int mid = (start + end) / 2;
        Number number1 = Update(start, mid, node*2, index, change);
        Number number2 = Update(mid+1, end, node*2+1, index, change);
        if (number1 == null) return tree[node] = number2;
        else if (number2 == null) return tree[node] = number1;
        else {
            return tree[node] = new Number(number1.two + number2.two, number1.three + number2.three);
        }
    }

    static class Number {

        int two;
        int three;

        public Number(int two, int three) {
            this.two = two;
            this.three = three;
        }

    }
}

