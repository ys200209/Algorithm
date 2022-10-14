package BOJ.String_Algorithm;

import java.io.*;

public class Main7_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] arr = str.substring(1, str.length() - 1).split(",");
            boolean isReverse = false;
            boolean isError = false;
            int startIndex = 0;
            int endIndex = n-1;

            for(int i=0; i<p.length(); i++) {
                if (p.charAt(i) == 'R') isReverse = !isReverse;
                else {
                    if (startIndex > endIndex) {
                        isError = true;
                        break;
                    }

                    if (!isReverse) startIndex++;
                    else endIndex--;
                }
            }

            if (isError) sb.append("error\n");
            else {
                int index = isReverse ? endIndex : startIndex;
                sb.append("[");
                if ((isReverse && index >= startIndex) || (!isReverse && index <= endIndex)) sb.append(arr[index]);
                while(true) {
                    index = isReverse ? index-1 : index+1;

                    if ((isReverse && index < startIndex) || (!isReverse && index > endIndex)) break;
                    sb.append("," + arr[index]);
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }

}
