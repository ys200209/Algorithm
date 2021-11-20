import java.util.concurrent.Semaphore;

public class Sem {
	public static Semaphore writer = new Semaphore(1);
    public static Semaphore reader = new Semaphore(1);
    public static int readers = 0, waitTime = 0; // 리더의 수
    public static String shared = "before";
    public static boolean arived = false; 

	public static void main(String[] args) {
		
		// Reader 스레드 생성
		new Thread() {
			public void run() {
				for(int i=1; i<=100; i++) {
					SomeResource resource = new SomeResource(i);
					resource.useReader();
				}
			}
		}.start();
		
		
		// Writer 스레드 생성
		new Thread() {
			public void run() {
				SomeResource resource = new SomeResource(1);
				resource.useWriter();
			}
		}.start();
		
		
	}
	
	
	static class SomeResource {
		
		private int semaNum;
		
		public SomeResource(int semaNum) {
			this.semaNum = semaNum;
		}
		
		public void useReader() {
			if (semaNum == 1) System.out.println("(Reader 도착)");
	        try {
	        	
	        	reader.acquire(); // P연산 (wait)
	        	
	        	if (arived) { 
            		waitTime += 1; // Writer가 기다리고 있는 시간
            		
            		if (waitTime >= 20) { // Writer가 Reader에게 20번 밀려났다면
            			System.out.println("waitTime = 20 !!");
                		while(readers != 0); // 이미 실행중인 Reader가 모두 빠져나갈때까지 기다렸다가
                		
                		writer.release(); // Writer를 수행시켜버린다.
                		
                		waitTime = 0;
                	}
            	}
	        	
            	readers += 1;
                if (readers == 1) { 
                	writer.acquire();
                }
                
                reader.release(); // V연산 (signal)
                
                // Reader 임계 영역 진입
                
                System.out.println("(Read "+semaNum+") : " + shared);

                reader.acquire(); // wait
                readers -= 1;
                if (readers == 0) {
                	writer.release();
                }
                reader.release(); // signal
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	    }
		
		public void useWriter() {
	        try {
	        	
	        	System.out.println("(Writer 도착)");
	        	arived = true;
	        	
            	writer.acquire();
            	
            	// Writer 임계 영역 진입
            	shared = "after";
            	arived = false;
            	System.out.println("(Writer "+semaNum+")");
            	
            	writer.release();
	            
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
	
}
