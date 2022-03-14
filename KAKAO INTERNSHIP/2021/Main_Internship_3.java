import java.util.*;

public class Main_Internship_3 {
    static int cursor;
    static Cell[] list;
    static Stack<Cell> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        // "OOOOXOOO"

        //System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
        // "OOXOXOOO"

        //System.out.println(solution(4, 0, new String[]{"C", "C", "C", "Z", "C"}));
        // "XXXO"

    }

    public static String solution(int n, int k, String[] cmd) {
        cursor = k;
        list = new Cell[n];
        for(int i=0; i<n; i++) { // �� ���� ���� �ε����� ����
            if (i == n-1) list[i] = new Cell(i-1, i, -1);
            else list[i] = new Cell(i-1, i, i+1);
        }

        for(int i=0; i<cmd.length; i++) {
            String[] commands = cmd[i].split(" ");
            if (commands[0].equals("U")) {
                for(int j=0; j<Integer.parseInt(commands[1]); j++) {
                    cursor = list[cursor].front; // Ŀ���� �ش��ϴ� ���� front ���� �ε����� �̵�
                }
            } else if (commands[0].equals("D")) {
                for(int j=0; j<Integer.parseInt(commands[1]); j++) {
                    cursor = list[cursor].back; // Ŀ���� �ش��ϴ� ���� back ���� �ε����� �̵�
                }
            } else if (commands[0].equals("C")) {
                int front = list[cursor].front;
                int back = list[cursor].back;

                if (front != -1 && back != -1) { // �����Ϸ��� ���� �� ������ �ƴ�, ��� ���̶��
                    list[front].back = back; // �� ���� ���� �ε����� ����
                    list[back].front = front;
                } else { 
                    if (front == -1) { // �� ���� ���̶��
                        list[back].front = -1; // �ڽ��� back ���� �ε����� ���� ����
                    } else { // �� ���� ���̶�� 
                        list[front].back = -1; // �ڽ��� front ���� �ε����� ���� ����
                    }
                }

                stack.push(list[cursor]); // ���� �� ���� ������ ���� Stack �ڷᱸ��
                if (back != -1) cursor = list[cursor].back; // �� ������ ���� �ƴ϶�� ���� �� ���� �ø���.
                else cursor = list[cursor].front; 
            } else {
                Cell cell = stack.pop(); // ���� �ֱٿ� ������ ���� ����
                if (cell.front != -1 && cell.back != -1) { // ������ ���� �� ������ �ƴ�, ��� ���̶��
                    list[cell.front].back = cell.now; 
                    list[cell.back].front = cell.now;
                } else {
                    if (cell.front == -1) { // �� �� ���̶��
                        list[cell.back].front = cell.now;
                    } else { // �� �� ���̶��
                        list[cell.front].back = cell.now;
                    }
                }
                
            }
        }

        String[] result = new String[n];
        Arrays.fill(result, "O");

        while(!stack.isEmpty()) {
            result[stack.pop().now] = "X";
        }

        for(String s : result) {
            sb.append(s);
        }

        return sb.toString();
    }
}

class Cell {

    int front;
    int now;
    int back;

    public Cell(int front, int now, int back) {
        this.front = front;
        this.now = now;
        this.back = back;
    }

}