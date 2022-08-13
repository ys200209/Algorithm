import java.util.*;
import java.io.*;

public class test1_1 {
    
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");



}

class User {

    String name;
    List<String> hobby = new ArrayList<>();
    String intro;

    public User(String name, String hobby, String intro) {
        this.name = name;
        this.hobby.add(hobby);
        this.intro = intro;
    }

    

}