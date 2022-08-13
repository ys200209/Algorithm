import java.util.*;
import java.io.*;

public class Main_SK_2_2 {
    
    
    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(new String[]{"1","2","4","3","3","4","1","5"}, 
        new String[]{"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5",
        "write 6 1 3 3 9", "read 9 1 0 7"})));
        // ["24","3415","4922","12492215","13"]

        /*System.out.println(Arrays.toString(solution(new String[]{"1","1","1","1","1","1","1"}, 
        new String[]{"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5",
        "write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"})));
        // ["338","38","8888","3385551","38555","29"]*/

    }

    public static String[] solution(String[] arr, String[] processes) {
        ArrayList<String> result = new ArrayList<>();
        Queue<Process> processQueue = new LinkedList<>();
        Queue<Process> taskQueue = new LinkedList();
        Queue<Process> readQueue = new LinkedList<>(); // �б� ��� ť
        Queue<Process> writeQueue = new LinkedList<>(); // ���� ��� ť
        

        for(int i=0; i<processes.length; i++) {
            String[] process = processes[i].split(" ");

            String command = process[0];
            int t1 = Integer.parseInt(process[1]);
            int t2 = Integer.parseInt(process[2]);
            int A = Integer.parseInt(process[3]);
            int B = Integer.parseInt(process[4]);
            int C = 0;
            if (command.equals("write")) C = Integer.parseInt(process[5]);

            processQueue.offer(new Process(command, 0, t1, t2, A, B, C));
        }

        int resultTime = 0; // �迭�� ����� ���� �ð� ����
        int time = 0; // �� �ð��� �帧�� ����� ����
        while(!processQueue.isEmpty() || !taskQueue.isEmpty() || !readQueue.isEmpty() || !writeQueue.isEmpty()) {
            
            if (!taskQueue.isEmpty()) { // �۾� ���μ����� �۾��� �ִٸ�
                if (time >= taskQueue.peek().startTime + taskQueue.peek().t2) { // �۾��� ����ƴٸ� 
                    Process pro = taskQueue.poll();
                    if (pro.command.equals("read")) { // �б� �۾��̾��ٸ� ������ ����
                        String str = "";
                        for(int i=pro.A; i<=pro.B; i++) {
                            str += arr[i];
                        }
                        result.add(str);
                    } else { // ���� �۾��̾��ٸ� ���� ���Ž�Ŵ
                        for(int i=pro.A; i<=pro.B; i++) {
                            arr[i] = Integer.toString(pro.C);
                        }
                        // System.out.println("���ŵ� �� : " + Arrays.toString(arr));
                    }
                    // System.out.println("�۾��� ��ħ : "  + time);
                    continue;
                }
            }

            if (!processQueue.isEmpty()) {
                if (time >= processQueue.peek().t1) { // ���μ����� �����ߴٸ�
                    Process pro = processQueue.poll();

                    if (pro.command.equals("read")) readQueue.offer(pro);
                    else writeQueue.offer(pro);
                }
            }
            
            if (!writeQueue.isEmpty()) {
                if (!taskQueue.isEmpty()) {
                    time++;
                    resultTime++;
                    continue;
                }

                Process pro = writeQueue.poll();
                pro.startTime = time; // �۾� ���� �ð��� ��������
                // System.out.println("(write) �۾��� ���۵� : " + pro.startTime);
                taskQueue.offer(pro);
                
                continue;
            } else if (!readQueue.isEmpty()) {
                if (!writeQueue.isEmpty()) {
                    time++;
                    resultTime++;
                    continue;
                }

                if (!taskQueue.isEmpty() && taskQueue.peek().command.equals("write")) {
                    time++;
                    resultTime++;
                    continue;
                }

                Process pro = readQueue.poll();
                pro.startTime = time; // �۾� ���� �ð��� ��������
                // System.out.println("(read) �۾��� ���۵� : " + pro.startTime);
                taskQueue.offer(pro);
                continue;
            }

            if (taskQueue.isEmpty() && readQueue.isEmpty() && writeQueue.isEmpty()) time++;
            else {
                resultTime++;
                time++;
            }
        }

        result.add(Integer.toString(resultTime));

        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
}

class Process {

    String command;
    int startTime;
    int t1;
    int t2;
    int A;
    int B;
    int C;
    
    public Process(String command, int startTime, int t1, int t2, int A, int B, int C) {
        this.command = command;
        this.startTime = startTime;
        this.t1 = t1;
        this.t2 = t2;
        this.A = A;
        this.B = B;
        this.C = C;
    }

}