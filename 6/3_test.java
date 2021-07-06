import java.util.*;

class Main6_3 {
    static int N;
    static String[][] student;

    public static void main(String[] args) {

        /*
        N명의 학생 정보가 있을 때, 학생의 이름과 성적을 입력받아 성적이 낮은 순서대로
        학생의 이름을 출력하는 프로그램을 작성
        ex)
        2
        홍길동 95
        이순신 77
        -> 이순신 홍길동
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        student = new String[N][2];
        sc.nextLine();
        for(int i=0; i<N; i++) {
            student[i][0] = sc.next();
            student[i][1] = sc.next();
        }

        for(int i=1; i<N; i++) {
            if(Integer.parseInt(student[i-1][1]) > Integer.parseInt(student[i][1])) {
                String[] temp = student[i-1];
                student[i-1] = student[i];
                student[i] = temp;
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(student[i][1] + " ");
        }






    }

}
