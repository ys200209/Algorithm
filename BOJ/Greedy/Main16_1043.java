import java.util.*;
import java.io.*;

public class Main16_1043 {
    static int N, M, trueCount, result=0;
    static Map<Integer, Boolean> trueMap = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        while(st.hasMoreTokens()) {
            trueMap.put(Integer.parseInt(st.nextToken()), true);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] party = new int[Integer.parseInt(st.nextToken())];

            int j=0;
            boolean isTrue = false; // ������ �ƴ��ڰ� �ִ°�
            while(st.hasMoreTokens()) {
                party[j] = Integer.parseInt(st.nextToken());
                if (trueMap.containsKey(party[j])) {
                    if (trueMap.get(party[j]) == true) isTrue = true; // �� ��Ƽ�� ������ �ƴ��ڰ� �����Ѵ�.
                }
                j++;
            }

            for(int person : party) {
                if (isTrue) { // ������ �ƴ��ڰ� �����Ѵٸ�
                    if (trueMap.get(person) == null) trueMap.put(person, true);
                    else {
                        if (trueMap.get(person) == false) { // ���� �������� ���� �ڰ� �ִٸ�
                            System.out.println(result);
                            return;
                        }
                    }
                } else { // �������� �ʴ´ٸ�
                    trueMap.put(person, false);
                }
            }

            if (!isTrue) result++;

        }

        System.out.println("result : " + result);

    }

}
