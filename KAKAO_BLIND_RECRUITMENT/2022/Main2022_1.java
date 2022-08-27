import java.util.*;

public class Main2022_1 {
    static Map<String, User> user = new HashMap<>(); // <유저명, 유저 정보>
    static Map<String, Integer> result = new HashMap<>(); // <유저명, 메일 받은 수>

    public static void main(String[] args) {

        // 신고 결과 받기 (Level : 1)
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"},
        new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2))); // [2, 1, 1, 0]

        // System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"},
        // new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3))); // [0, 0]

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        for(int i=0; i<id_list.length; i++) { // 유저 등록
            user.put(id_list[i], new User()); 
            result.put(id_list[i], 0); 
        }

        for(int i=0; i<report.length; i++) { // 신고 목록
            String user1 = report[i].split(" ")[0];
            String user2 = report[i].split(" ")[1];

            if (!user.get(user1).getReport().contains(user2)) { // 중복 신고가 아니라면
                user.get(user1).addReport(user2); // user1이 user2를 신고했다.
                user.get(user2).addBeReported(user1); // user2가 user1에게 신고 당했다.
            }
            
        }

        for(String s : user.keySet()) {
            if (user.get(s).getBeReported().size() >= k) {
                for(String name : user.get(s).getBeReported()) { // 자신을 신고한 유저들을 탐색
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

    private ArrayList<String> report; // 본인이 신고한 유저
    private ArrayList<String> beReported; // 본인을 신고한 유저

    public User() { // 기본 생성자
        report = new ArrayList<>();
        beReported = new ArrayList<>();
    }

    public void addReport(String user) {
        report.add(user); // 자신이 신고한 유저 추가
    }

    public void addBeReported(String user) {
        beReported.add(user); // 자신을 신고한 유저 추가
    }

    public ArrayList<String> getReport() {
        return report;
    }

    public ArrayList<String> getBeReported() { 
        return beReported;
    }

}