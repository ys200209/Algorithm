import java.util.*;

class Main14_23 {
    static String name;
    static int N, score1, score2, score3, index;
    static Student[] students;
    static Student student;
    public static void main(String[] args) {
        
        /*
            1. 국어 점수가 감소하는 순서
            2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
            3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로. (단, 대문자가 소문자보다 작으므로 사전 순으로 앞에 옴)
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        students = new Student[N];

        Comparator<Integer> increase = (o1, o2) -> o1.compareTo(o2);

        System.out.println("1");
        for(int i=0; i<N; i++) {
            name = sc.next();
            score1 = sc.nextInt();
            score2 = sc.nextInt();
            score3 = sc.nextInt();
            student = new Student(name, score1, score2, score3);
            
            students[i] = student;
        }
        System.out.println("2");
        for(int i=0; i<N; i++) {
            System.out.println("students"+i+" : " + students[i].getName() + ", " + 
                students[i].getScore1() + ", " + students[i].getScore2() + ", " + students[i].getScore3());
        }

        for(int i=0; i<N; i++) {
            
        }

    }

}

class Student {
    String name;
    int score1;
    int score2;
    int score3;

    Student(String name, int score1, int score2, int score3) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public String getName() {
        return name;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }
}