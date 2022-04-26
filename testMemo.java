import java.util.*;
import java.io.*;

public class testMemo {
    static int count = 1; 
    static String text = "";
    static String[] list;
    static Map<String, String> memoMap = new HashMap<>();
    static ArrayList<String> quesList = new ArrayList<>();
    static ArrayList<String> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try {
            FileInputStream input = new FileInputStream("C:\\Users\\Lee\\Desktop\\testMemo.txt");
            InputStreamReader reader = new InputStreamReader(input, "UTF-8");
            BufferedReader br = new BufferedReader(reader);

            int cur;
            while((cur = br.read()) != -1) {
                text += (char)cur;
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error!");
        }

        list = text.split("\\[");

        for(int i=0; i<list.length; i++) {
            if (list[i].split("->").length > 1) {
                memoMap.put(("[" + list[i].split("->")[0]), list[i].split("->")[1]);
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(String quest : memoMap.keySet()) { // 161 개의 질문
            System.out.print(count + " : " + quest);
            br.readLine();
            System.out.print("-> " + memoMap.get(quest));
            br.readLine();
            count++;
        }

    }
}