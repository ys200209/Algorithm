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
        for(int i=0; i<n; i++) { // 각 셀의 참조 인덱스를 설정
            if (i == n-1) list[i] = new Cell(i-1, i, -1);
            else list[i] = new Cell(i-1, i, i+1);
        }

        for(int i=0; i<cmd.length; i++) {
            String[] commands = cmd[i].split(" ");
            if (commands[0].equals("U")) {
                for(int j=0; j<Integer.parseInt(commands[1]); j++) {
                    cursor = list[cursor].front; // 커서에 해당하는 셀의 front 참조 인덱스로 이동
                }
            } else if (commands[0].equals("D")) {
                for(int j=0; j<Integer.parseInt(commands[1]); j++) {
                    cursor = list[cursor].back; // 커서에 해당하는 셀의 back 참조 인덱스로 이동
                }
            } else if (commands[0].equals("C")) {
                int front = list[cursor].front;
                int back = list[cursor].back;

                if (front != -1 && back != -1) { // 삭제하려는 셀이 양 끝값이 아닌, 가운데 셀이라면
                    list[front].back = back; // 양 셀의 참조 인덱스를 변경
                    list[back].front = front;
                } else { 
                    if (front == -1) { // 맨 앞의 셀이라면
                        list[back].front = -1; // 자신의 back 참조 인덱스의 셀만 변경
                    } else { // 맨 뒤의 셀이라면 
                        list[front].back = -1; // 자신의 front 참조 인덱스의 셀만 변경
                    }
                }

                stack.push(list[cursor]); // 삭제 후 복구 연산을 위한 Stack 자료구조
                if (back != -1) cursor = list[cursor].back; // 맨 마지막 행이 아니라면 삭제 후 행을 올린다.
                else cursor = list[cursor].front; 
            } else {
                Cell cell = stack.pop(); // 가장 최근에 삭제된 셀을 복구
                if (cell.front != -1 && cell.back != -1) { // 복구된 셀이 양 끝값이 아닌, 가운데 셀이라면
                    list[cell.front].back = cell.now; 
                    list[cell.back].front = cell.now;
                } else {
                    if (cell.front == -1) { // 맨 앞 셀이라면
                        list[cell.back].front = cell.now;
                    } else { // 맨 끝 셀이라면
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