import java.util.*;

class MainBlind2019_1 {

    public static void main(String[] args) {

        // 2019 카카오 블라인드 테스트. 오픈 채팅방 (2)

        System.out.println(Arrays.toString(solution(new String[] {
            "Enter uid1234 Muzi", 
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        })));

        /*
        ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
        */

    }

    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        String action = null;
        String userID = null;
        String userNick = null;
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<record.length; i++) {
            action = record[i].split(" ")[0];
            if (!action.equals("Leave")) {
                userID = record[i].split(" ")[1];
                userNick = record[i].split(" ")[2];
                map.put(userID, userNick);
            }
        }

        for(int i=0; i<record.length; i++) {
            action = record[i].split(" ")[0];
            if (action.equals("Enter")) {
                userID = record[i].split(" ")[1];
                list.add(map.get(userID) + "님이 들어왔습니다.");

            } else if (action.equals("Leave")) {
                userID = record[i].split(" ")[1];
                list.add(map.get(userID) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
    
}
