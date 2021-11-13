import java.util.*;

public class Market {
   public static void main(String[] args) {

//      System.out.println("베이커리 알고리즘 시작");
//      Scanner sc = new Scanner(System.in);
//      System.out.print("프로그램에 참여 할 스레드의 개수 입력 : ");
//      int num = sc.nextInt();
//      sc.close();
      
      int num = 10;
      int[] threadFinish = {num};
      boolean choosing[] = new boolean[num];
      int ticket[] = new int[num];
      long beforeTime = System.currentTimeMillis(); //시작시간 측정
      for( int i = 0; i < ticket.length; i++) {
         Customer customer = new Customer(choosing, ticket, i+" thread", threadFinish, beforeTime);
         customer.start();
         try{
            //Thread.sleep(1000);
         }catch(Exception e) {
            
         }
        
      }
   }
}