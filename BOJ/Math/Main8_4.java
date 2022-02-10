import java.util.*;
import java.io.*;

public class Main8_4 {
    static int A, B, V, result=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        result = (V-A) % (A-B) == 0 ? (V-A) / (A-B) : (V-A) / (A-B) + 1;
        // 꼭대기로 올라가는 날에는 잠을 안자기 때문에 A만큼 온전히 올라감.
        // 따라서 높이 V에서 A만큼을 뺀 나머지 길이는 A만큼 올라갔다가 B만큼 빼주는 것을 반복.

        System.out.println(result + 1);
        // 마지막 날에는 한번에 올라가기 때문에 마지막 날(+1)을 더해줌

    }
}