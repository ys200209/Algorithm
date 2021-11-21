import java.util.*;
import java.util.concurrent.Semaphore;

public class Moniter1 { 
   public static int readers=0; // 리더의 수
   public static boolean writeLock = false; // 라이터가 쓰고 있을 경우 true
   public static boolean canWrite; // 조건 변수
   public static boolean canRead; // 조건 변수
 
   public static void main(String[] args) {
      final SomeResource resource = new SomeResource(3); 
      
      // 1. 세마포어 queue를 어떻게 구현할 것인가
      // 2. canRead와 canWrite의 의미
      // 3. signal과 wait가 의미하는 P연산과 V연산 구현방법

   }

   // 읽기 전에 수행되는 진입 루틴
   public static void beginRead() {
      // 라이터가 현재 쓰고 있거나 쓰려고 대기 중이면 리더는 대기하고 만약 그렇지 않는 한 계속 진행할 수 있다.

      if (writeLock || queue(canWrite)) { // 라이터가 대기중인지 확인하는 boolean 함수 queue() 를 이용한다.

         // semaphore.availablePermits()
      }

      ++readers; // 또 다른 리더가 존재함

      signal(canRead); // 대기 중인 리더들을 진행시킴 (읽기 시작)
   }

   // 읽은 후에 호출되는 진입 루틴 (스레드가 읽기를 다 마치고 리더의 수를 1만큼 감소시킴)
   public static void endRead() {  // 모든 리더를 다 수행하고 나서야 write 작업을 수행
      --readers; // 리더가 하나 줄어듦

      // 읽고 있는 리더가 없다면 라이터가 쓸 수 있게 허용함
      if (readers == 0) {
         signal(canWrite); // 라이터가 진행하도록 허용함
      }
   }

   // 쓰기를 수행하기 전에 호출되는 진입 루틴
   public static void beginWrite() {
      // 리더가 읽고 있거나 라이터가 쓰고 있으면 대기함 (라이터는 배타적으로 접근해야 한다)
      if (readers > 0 || writeLock) {
         wait(canWrite); // 쓰기가 허용될 때까지 대기함
      }
      writeLock = true; // 모든 리더, 라이터를 막음 (쓰기전에 막음으로써 임계영역 접근에 상호배제를 충족)
   }

   // 쓰기 수행 후에 호출되는 진입 루틴
   public static void endWirte() {
      writeLock = false; // 잠금 해제
      // 리더가  진입하려고 대기 중이면 신호함
      if (queue(canRead)) {
         signal(canRead); // 대기 중인 리더들에게 캐스캐이딩함 (대기중인 모든 리더가 활성화될 때까지)
      }
      else { // 대기 중인 리더가 없으면 라이터에게 신호함
         signal(canWrite); // 대기 중인 라이터 중 하나가 작업을 진행할 수 있음
      }
   }
 }
 
 
class SomeResource_ {
   private final Semaphore semaphore;
   private final int maxThread;
    
   public SomeResource(int maxThread) { 
      this.maxThread = 0;
      this.semaphore = new Semaphore(maxThread); 
   }
     
   public void use() {
      try {
         semaphore.acquire(); 

         SemaphoreTest.sum += 1; 
           
         semaphore.release(); 
 
         if (SemaphoreTest.sum == SemaphoreTest.num) { 
               System.out.println("finish"); 
               System.out.println("실행 시간 : " + (System.currentTimeMillis()-SemaphoreTest.startTime) + " ms"); 
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

 
 
 