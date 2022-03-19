import java.util.*;
import java.io.*;

public class Main_SK_2_4 {
    static String password = "";
    static int M, K;
    static Map<Integer, Integer> btnMap = new HashMap<>();
    static Map<String, Integer> pwdList = new HashMap<>(); // �н����� �ĺ�
    static ArrayList<Integer> btnList = new ArrayList<>(); // ���� ��ư ����
    static int[] record; // ù��° ���ڵ带 �̿��Ͽ� �ĺ� ��й�ȣ���� ���߸�
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(8, 4, 4, new int[][]{{1, 5, 1, 3}, {5, 7, 5, 6}})));
        // [1, 3, 1, 2]

        // System.out.println(Arrays.toString(solution(8, 4, 4, new int[][]{{1, 5, 1, 3}})));
        // [1, 4, 1, 3]

        // System.out.println(Arrays.toString(solution(10, 3, 3, new int[][]{{1, 2, 3}, {5, 7, 10}})));
        // 



    }

    public static int[] solution(int n, int m, int k, int[][] records) {
        int[] answer = {};
        // int number = new int[n+1]; // 1~n ������ ��ȣ�߿��� ���� ���� �ĺ��� ������ �迭
        ArrayList<Integer> number = new ArrayList<>(); // ��й�ȣ�� ���� ��
        M = m;
        K = k;

        record = records[0];
        
        for(int i=0; i<k; i++) {
            if (!btnList.contains(record[i])) btnList.add(record[i]);
        }
        Collections.sort(btnList);

        System.out.println("btnList : " + btnList);
        
        DFS(0, 0);

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(pwdList.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            if (entry1.getValue() == entry2.getValue()) {
                return entry2.getKey().compareTo(entry1.getKey());
            } else {
                return entry2.getValue() - entry1.getValue();
            }
        });

        answer = new int[K];
        String[] result = list.get(0).getKey().split("");
        
        for(int i=0; i<result.length; i++) {
            answer[i] = Integer.parseInt(result[i]);
        }

        System.out.println("�ĺ�");
        for(String s : pwdList.keySet()) {
            System.out.println(s + " : " + pwdList.get(s));
        }

        return answer;
    }

    public static void DFS(int index, int count) {
        if (index == btnList.size()) {
            String pw = "";

            for(int n : btnMap.keySet()) {
                System.out.println(n + " : " + btnMap.get(n));
            }

            for(int n : record) {
                pw += btnMap.get(n);
            }
            System.out.println("pw : " + pw);
            if (set.add(pw)) pwdList.put(pw, pwdList.getOrDefault(pw, 0) + 1);
            
            return;
        }

        for(int i=index; i<M; i++) {
            if (btnList.get(count) == 1) {
                btnMap.put(1, 1);
            } else {
                btnMap.put(btnList.get(count), i+1);
            }
            DFS(i+1, count+1);
        }

    }

}