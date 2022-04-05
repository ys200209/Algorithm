import java.util.*;
import java.io.*;

public class testMemo {
    static String text = "";
    static String[] list;
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
        System.out.println("size : " + list.length);
        for(int i=0; i<list.length; i++) {
            quesList.add("[" + list[i].split("->")[0]);

            if (list[i].split("->").length > 1) answerList.add(list[i].split("->")[1]);
        }

        System.out.println("quesList : " + quesList);
        System.out.println("answerList : " + answerList);
    }
}
