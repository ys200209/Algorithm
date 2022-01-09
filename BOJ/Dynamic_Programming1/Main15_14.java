import java.util.*;

public class Main15_14 {
    static int start, checkPoint1=0, checkPoint2=-1, len, result=0;
    static String str, str1, str2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        str1 = scanner.next();
        str2 = scanner.next();

        for(int i=str1.length(); i>1; i--) {
            len = 0;
            str = "";
            start = 0;

            for(int j=i; j<=str1.length(); j++) {

                if (checkPoint1 >= str2.length()) break;
                
                // System.out.println("start = " + start + ", j = " + j + ", str1.substring(start, j) = " + str1.substring(start, j));
                if (str1.substring(start, j).indexOf(str2.substring(checkPoint1, str2.length())) != -1 && 
                        str1.substring(start, j).indexOf(str2.substring(checkPoint1, str2.length())) > checkPoint2) {
                    checkPoint1 = j;
                    len += j - start; 
                    System.out.println("checkPoint1 = " + checkPoint1);
                }
                
                
                start++;
            }
            result = Math.max(result, len);
        }
        
        if (result == 0) System.out.println("1");
        else System.out.println(result);

    }
    
}
