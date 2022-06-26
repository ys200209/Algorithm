import java.util.*;
import java.io.*;

public class Main23_13460 {
    
    public static void main(String[] args) throws IOException {

        Runnable runnable = () -> {
            System.out.println("Hello");
        };
        
        Set<Test> set = new HashSet<>();

        Test test1 = new Test(1, 3);
        Test test2 = new Test(1, 3);

        set.add(test1);
        set.add(test2);


        for(Test t : set) {
            System.out.println("(" + t.x + ", " + t.y + ")");
        }
        
    }

}

class Test {

    int x;
    int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Test) {
            Test test = (Test)o;
            return (x == test.x) && (y == test.y);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x + y;
    }

}