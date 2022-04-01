import java.io.*;
import java.util.*;

public class Main23_1 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int HH = Integer.parseInt(st.nextToken());
        int MM = Integer.parseInt(st.nextToken());

        int late = Integer.parseInt(br.readLine());

        HH += ((MM + late) / 60);
        MM = (MM + late) % 60;

        System.out.println((HH%24) + " " + MM);
    }
}