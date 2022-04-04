import java.util.*;

public class Main2021_3 {
    static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>(); // <사원명, 수익금>
    static Map<String, Integer> indexMap = new HashMap<>(); // 사원명에 따른 참조 인덱스

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
        new String[]{"young", "john", "tod", "emily", "mary"},
        new int[]{12, 4, 2, 5, 10}))); // [360, 958, 108, 0, 450, 18, 180, 1080]

    }
    
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        

        for(int i=0; i<enroll.length; i++) {
            graph.add(new ArrayList<>()); // 사원 수 만큼 그래프 생성
            indexMap.put(enroll[i], i); // 각 사원수에 해당하는 참조 인덱스 부여
            map.put(enroll[i], 0); // 현재 각 사원의 수익금
        }

        for(int i=0; i<referral.length; i++) {
            if (!referral[i].equals("-")) { // 참여 시킨 놈이 존재한다면
                graph.get(indexMap.get(enroll[i])).add(referral[i]);
            }
        }

        for(int i=0; i<seller.length; i++) { // 노예가 팔아먹은 값
            DFS(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) { // 결과
            answer[i] = map.get(enroll[i]);
        }
        return answer;
    }

    public static void DFS(String name, int cost) {
        int c = cost - cost/10; // 10% 제외한 값
        
        map.put(name, map.get(name) + c);
        
        for(String n : graph.get(indexMap.get(name))) {
            DFS(n, (int)cost/10); //
        }
    }
}