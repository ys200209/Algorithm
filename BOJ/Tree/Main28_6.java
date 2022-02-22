import java.util.*;

public class Main28_6 {
    static Scanner scanner = new Scanner(System.in);
    static Hall hall = new Hall();
    public static void main(String[] args) {

        System.out.println("���� �ý���.");
        while(true) {
            System.out.print("����:1, ��ȸ:2, ���:3, ����:4 > ");
            int command = scanner.nextInt();

            if (command > 4 || command < 1) continue;

            if (command == 4) break;

            if (command == 1) select1();
            else if (command == 2) select2();
            else if (command == 3) select3();

        }

    }

    public static void select1() {
        int Class;
        while(true) {
            System.out.print("��� ����. S(1), A(2), B(3) > ");
            Class = scanner.nextInt();

            if (Class < 1 || Class > 3) {
                System.out.println("�߸��� ����Դϴ�.");
                continue;
            }
            
            if (Class == 1) hall.showS();
            else if (Class == 2) hall.showA();
            else hall.showB();

            System.out.print("�̸� > ");
            String name = scanner.next();
            System.out.print("��ȣ > ");
            int number = scanner.nextInt();

            if (number < 1 || number > 10) {
                System.out.println("���� ��ȣ�Դϴ�.");
                continue;
            }

            if (Class == 1) hall.S[number-1] = name;
            else if (Class == 2) hall.A[number-1] = name;
            else hall.B[number-1] = name;

            break;
        }
        
    }

    public static void select2() {
        hall.showAll();
    }

    public static void select3() {
        int Class;
        while(true) {
            System.out.print("��� ����. S(1), A(2), B(3) > ");
            Class = scanner.nextInt();

            if (Class < 1 || Class > 3) {
                System.out.println("�߸��� ����Դϴ�.");
                continue;
            }
            
            if (Class == 1) hall.showS();
            else if (Class == 2) hall.showA();
            else hall.showB();

            System.out.print("�̸� > ");
            String name = scanner.next();

            if (!hall.cancleHall(Class, name)) {
                System.out.println("�߸��� �̸��Դϴ�.");
                continue;
            }

            break;
        }
    }

}

class Hall {

    String[] S;
    String[] A;
    String[] B;

    public Hall() {
        S = new String[10];
        A = new String[10];
        B = new String[10];
        Arrays.fill(S, "---");
        Arrays.fill(A, "---");
        Arrays.fill(B, "---");
    }

    public void showS() {
        System.out.println("S : " + Arrays.toString(S));
    }

    public void showA() {
        System.out.println("A : " + Arrays.toString(A));
    }

    public void showB() {
        System.out.println("B : " + Arrays.toString(B));
    }

    public void showAll() {
        System.out.println("S : " + Arrays.toString(S));
        System.out.println("A : " + Arrays.toString(A));
        System.out.println("B : " + Arrays.toString(B));
        System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
    }

    public boolean cancleHall(int Class, String name) {
        if (Class == 1) {
            for(int i=0; i<10; i++) {
                if (S[i].equals(name)) {
                    S[i] = "---";
                    return true;
                }
            }
        } else if (Class == 2) {
            for(int i=0; i<10; i++) {
                if (A[i].equals(name)) {
                    A[i] = "---";
                    return true;
                }
            }
        } else {
            for(int i=0; i<10; i++) {
                if (B[i].equals(name)) {
                    B[i] = "---";
                    return true;
                }
            }
        }

        return false;
    }


}