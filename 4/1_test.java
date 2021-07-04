import java.util.*;

class Main4_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int X = 1; 
        int Y = 1;
        //int[] list = new int[N];
        
        for(int i=0; i<6; i++) {
            String pos = sc.next();
            switch(pos) {
                case "L":
                    Y = Y-1 > 0 ? Y-1 : Y;
                    System.out.println("(L)Y = " + Y);
                    break;
                case "R":
                    Y = Y+1 < N ? Y+1 : Y;
                    System.out.println("(R)Y = " + Y);
                    break;
                case "U":
                    X = X-1 > 1 ? X-1 : X;
                    System.out.println("(U)X = " + X);
                    break;
                case "D":
                    X = X+1 < N ? X+1 : X;
                    System.out.println("(D)X = " + X);
                    break;
            }
        }
        
        System.out.println("pos : " + X + ", " + Y);
    }

}