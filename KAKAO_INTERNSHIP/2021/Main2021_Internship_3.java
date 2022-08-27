import java.util.*;

public class Main2021_Internship_3 {
    static ArrayList<Process> list = new ArrayList<>();
    static Stack<Process> stack = new Stack<>();
    static int cursor;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        // OOOOXOOO
        
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
        // OOXOXOOO???
        

    }

    public static String solution(int n, int k, String[] cmd) {
        cursor = k;

        for(int i=0; i<n; i++) {
            
            if (i == 0) {
                list.add(new Process(-1, 0, 1));
            } else if (i == n-1) {
                list.add(new Process(n-2, n-1, -1));
            } else {
                list.add(new Process(i-1, i, i+1));
            }
        }
        
        for(int i=0; i<cmd.length; i++) {
            String[] c = cmd[i].split(" ");
            String command = c[0];
            
            if (command.equals("U")) {
                moveUp(Integer.parseInt(c[1])); 
            } else if (command.equals("D")) {
                moveDown(Integer.parseInt(c[1]));
            } else if (command.equals("C")) {
                remove();
            } else {
                rollBack();
            }
        }
        
        String[] answer = new String[n];
        Arrays.fill(answer, "O");

        while(!stack.isEmpty()) {
            answer[stack.pop().index] = "X";
        }
        
        for(int i=0; i<n; i++) {
            sb.append(answer[i]);
        }

        return sb.toString();
    }

    public static void moveUp(int move) {
        while(move != 0) {
            if (list.get(cursor).front == -1) return;

            cursor = list.get(cursor).front;
            move--;
        }
    }

    public static void moveDown(int move) {
        while(move != 0) {
            if (list.get(cursor).back == -1) return;

            cursor = list.get(cursor).back;
            move--;
        }
    }

    public static void remove() {
        if (list.get(cursor).front == -1) list.get(list.get(cursor).back).front = -1;
        else if (list.get(cursor).back == -1) list.get(list.get(cursor).front).back = -1;
        else {
            list.get(list.get(cursor).back).front = list.get(cursor).front;
            list.get(list.get(cursor).front).back = list.get(cursor).back;
        }

        stack.push(list.get(cursor));

        cursor = list.get(cursor).back == -1 ? list.get(cursor).front : list.get(cursor).back;
    }

    public static void rollBack() {
        Process process = stack.pop();

        if (process.front == -1) list.get(process.back).front = process.index;
        else if (process.back == -1) list.get(process.front).back = process.index;
        else {
            list.get(process.front).back = process.index;
            list.get(process.back).front = process.index;
        }
    }
}

class Process {

    int front;
    int index;
    int back;

    public Process(int front, int index, int back) {
        this.front = front;
        this.index = index;
        this.back = back;
    }
}