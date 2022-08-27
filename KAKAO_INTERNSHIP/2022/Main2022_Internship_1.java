import java.util.*;

class Main2022_Internship_1 {
    // 1, 2번을 하고, 점수를 얻어오기 위해 map에 점수를 추가하는 부분에서
    // 동일한 키가 있을 때의 값 갱신 및 동일성 판단 과정을 hashCode(), equals() 메서드를 언급하며 설명. 
    static String answer = "";
    static Map<String, Integer> map = new HashMap<>(); // <성격유형, 점수>

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        // TCMA

    }
    
    public static String solution(String[] survey, int[] choices) {
        for(int i=0; i<survey.length; i++) {
            String[] types = survey[i].split("");
            int choice = choices[i];

            if (choice == 4) continue; // 동점일 때는 무시

            // addScore(int, String) : 선택한 값에 따른 점수를 얻는 메서드
            if (choice < 4) addScore(choice, types[0]); // 선택 점수가 3점 이하라면 앞의 성격유형에 가점을 준다.
            else addScore(choice, types[1]); // 선택 점수가 5점 이상이라면 뒤의 성격유형에 가점을 준다.
        }

        // MBTI(String, String) : 두 성격 유형 값을 비교하여 하나의 유형을 결정하는 메서드
        MBTI("R", "T");
        MBTI("C", "F");
        MBTI("J", "M");
        MBTI("A", "N");

        return answer;
    }

    public static void addScore(int choice, String type) {
        // Map : getOrDefault(Key, defaultValue) -> 만약 Key값이 존재하지 않을 때 defaultValue 값을 가져옴
        // 물론 Key가 존재한다면 Key에 해당하는 Value를 가져옴
        if (choice < 4) {
            map.put(type, map.getOrDefault(type, 0) + (4 - choice)); // 4 - choice만큼 점수를 얻음
        } else {
            map.put(type, map.getOrDefault(type, 0) + (choice - 4)); // choice - 4만큼 점수를 얻음
        }
    }

    // ********** .charAt() : 문자 연산 시 해당 문자를 ASCII 코드로 변환하여 값 비교.   ***************
    public static void MBTI(String A, String B) { 
        // 둘 다 점수가 없을 경우
        // 사전 순으로 빠른 유형을 받아옴

        if (map.get(A) == null && map.get(B) == null) answer += A.charAt(0) > B.charAt(0) ? B : A;
        else if (map.get(A) == null) answer += B; // A의 점수가 없을 경우 B 유형을 가져옴
        else if (map.get(B) == null) answer += A; // B의 점수가 없을 경우 A 유형을 가져옴
        else { // 둘 다 값이 존재한다면

            // 점수가 동일하다면 사전 순으로 빠른 유형을 받아옴
            if (map.get(A) == map.get(B)) answer += A.charAt(0) > B.charAt(0) ? B : A;
            else if (map.get(A) > map.get(B)) answer += A; // 점수 차이대로 받아옴
            else answer += B;
        }
        
    }

}

/*
    Q1 : HashMap?
    Q1_2 : List, Set, Map에 대해서 자세히 설명하라. (HashXxx마저도.)
    Q2 : Map에서의 사용한 제네릭이란 : 런타임이 아닌 컴파일 레벨에서 Exception Validation
    Q3 : static 키워드를 사용해서 선언한 이유
    Q4 : Map 인터페이스의 .getOrDefault() 메서드 : 
*/ 