package BOJ.String_Algorithm;

import java.io.*;

public class Main7_1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        String answer="";
        for(int i=0; i<arr[0].length(); i++) {
            boolean isEqual = true;
            char c = arr[0].charAt(i);
            for(int j=1; j<arr.length; j++) {
                if (arr[j].charAt(i) != c) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) answer += c;
            else answer += "?";
        }
        System.out.println(answer);
    }
}
