import java.util.*;

class Main6_3 {
    static int N;
    static String[][] student;

    public static void main(String[] args) {

        /*
        N���� �л� ������ ���� ��, �л��� �̸��� ������ �Է¹޾� ������ ���� �������
        �л��� �̸��� ����ϴ� ���α׷��� �ۼ�
        ex)
        2
        ȫ�浿 95
        �̼��� 77
        -> �̼��� ȫ�浿
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
