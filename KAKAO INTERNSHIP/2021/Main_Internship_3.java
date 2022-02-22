import java.util.*;

public class Main_Internship_3 {
    static int cursor;
    static LinkedList<Cell> list = new LinkedList<>();
    static Stack<Cell> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        //System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        // "OOOOXOOO"

       // System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
        // "OOXOXOOO"

        System.out.println(solution(4, 0, new String[]{"C", "C", "C", "Z", "C"}));
        // "XXXO"

    }

    public static String solution(int n, int k, String[] cmd) {
        String[] answer = new String[n];
        
        list.add(new Cell(0, -1, 1));
        for(int i=1; i<n-1; i++) {
            list.add(new Cell(i, i-1, i+1));
        }
        list.add(new Cell(n-1, n-2, -1));

        for(Cell cell : list) {
            System.out.println(cell.start + " ~ " + cell.end);
        }
        System.out.println("------------------------");

        cursor = k;

        for(int i=0; i<cmd.length; i++) {
            String[] s = cmd[i].split(" ");
            String command = s[0];
            int count=0;
            if (command.equals("D") || command.equals("U")) count = Integer.parseInt(s[1]);
            // System.out.println("cursor : " + cursor);
            if (command.equals("D")) {
                for(int j=0; j<count; j++) cursor = list.get(cursor).end;
            } else if (command.equals("U")) {
                for(int j=0; j<count; j++) cursor = list.get(cursor).start;
            } else if (command.equals("C")) {
                System.out.println("(C)");
                stack.push(list.get(cursor));

                if (list.get(cursor).end == -1) { // 가장 끝 값을 삭제 (끝 값 갱신 인덱스 변화 X)
                    System.out.println("가장 끝 값");
                    list.get(list.get(cursor).start).end = -1;
                    cursor = list.get(cursor).start;
                } else if (list.get(cursor).start == -1) { // 가장 앞 값을 삭제 (앞 값 갱신, 인덱스 변화 O)
                    System.out.println("가장 앞 값");
                    list.get(list.get(cursor).end).start = -1;
                    cursor = list.get(cursor).end;
                } else {
                    //list.get(cursor-1).end = list.get(cursor).end;
                    //list.get(cursor+1).start = list.get(cursor).start;
                    System.out.println("중간 값 cursor : " + cursor);
                    list.get(list.get(cursor).start).end = list.get(cursor).end;
                    list.get(list.get(cursor).end).start = list.get(cursor).start;
                    cursor = list.get(cursor).end;
                }

                System.out.println("(C) after ------------------------ cursor : " + cursor);
                for(Cell c : list) {
                    System.out.println(c.start + " ~ " + c.end);
                }
                

            } else { // Z
                Cell cell = stack.pop();

                if (cell.index == 0) {
                    list.get(cell.index+1).start = cell.index;
                } else if (cell.index == n-1) {
                    list.get(cell.index-1).end = cell.index;
                } else {
                    list.get(cell.index-1).end = cell.index;
                    list.get(cell.index+1).start = cell.index;
                }


                System.out.println("(Z) after ------------------------");
                for(Cell c : list) {
                    System.out.println(c.start + " ~ " + c.end);
                }

            }

        }

        Arrays.fill(answer, "O");
        System.out.println("Stack");
        for(Cell cell : stack) {
            System.out.println(cell.index + " : " + cell.start + " ~ " + cell.end);
            answer[cell.index] = "X";
        }

        for(String s : answer) {
            sb.append(s);
        }

        System.out.println(Arrays.toString(answer));



        return sb.toString();
    }
    
}

class Cell {

    int index;
    int start;
    int end;

    public Cell(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

}