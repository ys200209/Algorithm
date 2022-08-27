import java.util.*;

public class Main2022_1 {
    static Map<String, User> user = new HashMap<>(); // <������, ���� ����>
    static Map<String, Integer> result = new HashMap<>(); // <������, ���� ���� ��>

    public static void main(String[] args) {

        // �Ű� ��� �ޱ� (Level : 1)
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"},
        new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2))); // [2, 1, 1, 0]

        // System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"},
        // new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3))); // [0, 0]

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        for(int i=0; i<id_list.length; i++) { // ���� ���
            user.put(id_list[i], new User()); 
            result.put(id_list[i], 0); 
        }

        for(int i=0; i<report.length; i++) { // �Ű� ���
            String user1 = report[i].split(" ")[0];
            String user2 = report[i].split(" ")[1];

            if (!user.get(user1).getReport().contains(user2)) { // �ߺ� �Ű� �ƴ϶��
                user.get(user1).addReport(user2); // user1�� user2�� �Ű��ߴ�.
                user.get(user2).addBeReported(user1); // user2�� user1���� �Ű� ���ߴ�.
            }
            
        }

        for(String s : user.keySet()) {
            if (user.get(s).getBeReported().size() >= k) {
                for(String name : user.get(s).getBeReported()) { // �ڽ��� �Ű��� �������� Ž��
                    result.put(name, result.get(name) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        int i=0;
        for(String name : id_list) {
            answer[i] = result.get(name);
            i++;
        }

        return answer;
    }

}

class User {

    private ArrayList<String> report; // ������ �Ű��� ����
    private ArrayList<String> beReported; // ������ �Ű��� ����

    public User() { // �⺻ ������
        report = new ArrayList<>();
        beReported = new ArrayList<>();
    }

    public void addReport(String user) {
        report.add(user); // �ڽ��� �Ű��� ���� �߰�
    }

    public void addBeReported(String user) {
        beReported.add(user); // �ڽ��� �Ű��� ���� �߰�
    }

    public ArrayList<String> getReport() {
        return report;
    }

    public ArrayList<String> getBeReported() { 
        return beReported;
    }

}