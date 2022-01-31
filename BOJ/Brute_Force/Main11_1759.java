import java.util.*;
import java.io.*;

public class Main11_1759 {
    static int L, C;
    static String[] A;
    static String str="", mom = "aeiou"; // 'a', 'e', 'i', 'o', 'u'
    static Set<String> set = new HashSet<>();
    static Queue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new String[C];
        
        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = st.nextToken();
            i++;
        }

        Arrays.sort(A);
        
        DFS(0, 0, 0, 0);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            pq.offer(iter.next()); // Set���κ��� ������ ����
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll() + "\n"); // ���ĵ� �ܾ� ���
        }

        System.out.println(sb);

    }

    public static void DFS(int index, int x, int y, int count) { // x : ���� ����, y : ���� ����
        if (count == L) {
            if (x >= 1 && y >= 2) { // ������ ���� �ɶ��� Set�� ����
                set.add(str);
            }
            return;
        }
        
        for(int i=index; i<C; i++) {
            str += A[i];
            if (mom.contains(A[i])) DFS(i+1, x+1, y, count+1);
            else DFS(i+1, x, y+1, count+1);
            str = str.substring(0, str.length()-1);
        }

    }
    
}
