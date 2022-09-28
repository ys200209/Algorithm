package BOJ.Brute_Force;

public class Main11_1799 {
    static int NUMBER=0;

    public static void main(String[] args) {

        System.out.println(solution(2, 4, 2, 1)); // "0111"

//        System.out.println(solution(16, 17, 2, 1)); // "0111"


    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        sb.append("0");

        int i=1;
        while(sb.length() < t*m) {
            sb.append(game(n, i));
            i++;
        }

//        System.out.println("sb = " + sb);

        String[] split = sb.toString().split("");
        for(i=1; i<=split.length; i++) {
            if (i%m == p%m) answer += split[i-1];

            if (answer.length() == t) break;
        }


        return answer;
    }

    private static String game(int n, int number) { 
        StringBuilder sb = new StringBuilder();

        while(number > 0) {
            int anInt = number%n;
//            System.out.println("anInt = " + anInt);
            if (anInt >= 10) sb.insert(0, (char)('A' + (anInt-10)));
            else sb.insert(0, anInt);

            number /= n;
//            System.out.println("(prime) sb = " + sb);
        }


//        if (anInt >= 10) return (char)('A' + (anInt-10));
//        else return sb.toString().charAt(0);
        return sb.toString();
    }

}