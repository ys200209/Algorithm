import java.util.*;
import java.io.*;

public class Main_19583 {
    static int START, END, FINISH, result=0;
    static Map<String, Boolean> student = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] times = br.readLine().split(" ");
        String[] time1 = times[0].split(":");
        START = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
        String[] time2 = times[1].split(":");
        END = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
        String[] time3 = times[2].split(":");
        FINISH = Integer.parseInt(time3[0]) * 60 + Integer.parseInt(time3[1]);

        String str;
        while((str = br.readLine()) != null) {
            String[] time = str.split(" ")[0].split(":");
            String name = str.split(" ")[1];

            int HH = Integer.parseInt(time[0]) * 60;
            int MM = Integer.parseInt(time[1]);

            if (HH+MM <= START) {
                student.put(name, false);
            }

            if (HH+MM >= END && HH+MM <= FINISH && student.containsKey(name)) {
                if (student.get(name) == false) {
                    student.put(name, true);
                    result++;
                }
            } 
        }
        System.out.println(result);
    }
}