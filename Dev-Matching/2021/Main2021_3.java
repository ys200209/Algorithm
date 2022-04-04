import java.util.*;

public class Main2021_3 {
    static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>(); // <�����, ���ͱ�>
    static Map<String, Integer> indexMap = new HashMap<>(); // ����� ���� ���� �ε���

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
        new String[]{"young", "john", "tod", "emily", "mary"},
        new int[]{12, 4, 2, 5, 10}))); // [360, 958, 108, 0, 450, 18, 180, 1080]

    }
    
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        

        for(int i=0; i<enroll.length; i++) {
            graph.add(new ArrayList<>()); // ��� �� ��ŭ �׷��� ����
            indexMap.put(enroll[i], i); // �� ������� �ش��ϴ� ���� �ε��� �ο�
            map.put(enroll[i], 0); // ���� �� ����� ���ͱ�
        }

        for(int i=0; i<referral.length; i++) {
            if (!referral[i].equals("-")) { // ���� ��Ų ���� �����Ѵٸ�
                graph.get(indexMap.get(enroll[i])).add(referral[i]);
            }
        }

        for(int i=0; i<seller.length; i++) { // �뿹�� �ȾƸ��� ��
            DFS(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) { // ���
            answer[i] = map.get(enroll[i]);
        }
        return answer;
    }

    public static void DFS(String name, int cost) {
        int c = cost - cost/10; // 10% ������ ��
        
        map.put(name, map.get(name) + c);
        
        for(String n : graph.get(indexMap.get(name))) {
            DFS(n, (int)cost/10); //
        }
    }
}