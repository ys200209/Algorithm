import java.util.*;

class MainBlind2021_3 {
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
        new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})));
        // [1,1,1,1,2,4]
    }
    
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i=0; i<info.length; i++) {
            String[] inf = info[i].split(" ");
            String lang = inf[0];
            String position = inf[1];
            String year = inf[2];
            String food = inf[3];
            int score = Integer.parseInt(inf[4]);

            people.add(new Person(lang, position, year, food, score));
        }

        for(int i=0; i<query.length; i++) {
            int count = 0;

            String[] q = query[i].split(" and ");
            String lang = q[0];
            String position = q[1];
            String year = q[2];
            String food = q[3].split(" ")[0];
            int score = Integer.parseInt(q[3].split(" ")[1]);

            for(int j=0; j<people.size(); j++) {
                Person person = people.get(j);

                if (isLang(person.lang, lang) && isPosition(person.position, position) &&
                    isYear(person.year, year) && isFood(person.food, food) && person.score >= score) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static boolean isLang(String s1, String s2) {
        if (s2.equals("-")) return true;
        else if (s1.equals(s2)) return true;
        else return false;
    }

    public static boolean isPosition(String s1, String s2) {
        if (s2.equals("-")) return true;
        else if (s1.equals(s2)) return true;
        else return false;
    }

    public static boolean isYear(String s1, String s2) {
        if (s2.equals("-")) return true;
        else if (s1.equals(s2)) return true;
        else return false;
    }

    public static boolean isFood(String s1, String s2) {
        if (s2.equals("-")) return true;
        else if (s1.equals(s2)) return true;
        else return false;
    }
    
}

class Person {

    String lang;
    String position;
    String year;
    String food;
    int score;

    public Person(String lang, String position, String year, String food, int score) {
        this.lang = lang;
        this.position = position;
        this.year = year;
        this.food = food;
        this.score = score;
    }



}