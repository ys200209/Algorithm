import java.util.*;

class Main4_2 {
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int hh = 0;
        int mm = 0;
        int ss = 0;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(hh <= N) {
            ss++;
            if (ss == 60) {
                mm++;
                ss = 0;
                if (mm == 60) {
                    hh++;
                    mm = 0;
                }
            }
            if (Integer.toString(ss).contains("3") || Integer.toString(mm).contains("3")
                    || Integer.toString(hh).contains("3")) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("실행 시간 : " + (System.currentTimeMillis() - startTime) + "ms");
    }

}
