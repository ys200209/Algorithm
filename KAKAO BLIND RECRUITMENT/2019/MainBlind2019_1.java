import java.util.*;

class MainBlind2019_1 {

    public static void main(String[] args) {

        // 오픈 채팅방 (2)

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
        String userID = null;
        String userNick = null;
        int count = record.length;

        for (int i=0; i<record.length; i++) {
            if (!record[i].split(" ")[0].equals("Leave")) {
                userID = record[i].split(" ")[1];
                userNick = record[i].split(" ")[2];
                map.put(userID, userNick);
            }
            if (record[i].split(" ")[0].equals("Change")) {
                count--;
            }
        }

        String[] answer = new String[count];
        count=0;

        for(int i=0; i<record.length; i++) {
            if (record[i].split(" ")[0].equals("Enter")) {
                userID = record[i].split(" ")[1];
                answer[count] = map.get(userID) + "님이 들어왔습니다.";

            } else if (record[i].split(" ")[0].equals("Leave")) {
                userID = record[i].split(" ")[1];
                answer[count] = map.get(userID) + "님이 나갔습니다.";
            }

            count ++;
        }


        return answer;
    }
    
}
