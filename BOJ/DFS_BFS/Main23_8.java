import java.util.*;

class Main23_8 {
    public static int N, K, result=0;
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;

    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 8번
        
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        visited = new boolean[100001];

        if (N != K) BFS();

        System.out.println(result);
        
    }

    public static void BFS() {

        queue.offer(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int moveTo;

            for(int i=0; i<size; i++) {
                int temp = queue.poll();
                

                if (N < K) { // N이 K보다 작다면 더하든 빼든 멀 하든 상관없다.
                    moveTo = temp-1;
                    if (moveTo >= 0) {
                        if (!visited[moveTo]) { // 이미 탐색했던 곳은 더는 탐색하지 않도록.
                            queue.offer(moveTo);
                            visited[moveTo] = true;
                        }
                    }

                    moveTo = temp+1;
                    if (moveTo < visited.length) {
                        if (!visited[moveTo]) { // 이미 탐색했던 곳은 더는 탐색하지 않도록.
                            queue.offer(moveTo); 
                            visited[moveTo] = true;
                        }
                    }

                    moveTo = temp*2;
                    if (moveTo < visited.length) {
                        
                        if (!visited[moveTo]) { // 이미 탐색했던 곳은 더는 탐색하지 않도록.
                            queue.offer(moveTo);
                            visited[moveTo] = true;
                        }
                    }
                    
                    
                } else { // N이 K보다 크다면 빼야만 한다.
                    moveTo = temp-1;
                    if (moveTo >= 0) {
                        if (!visited[moveTo]) { 
                            queue.offer(moveTo);
                            visited[moveTo] = true;
                        }
                    }
                }

                if (visited[K]) { 
                    result += 1;
                    return; // 동생과 위치가 같아졌다면 그만둔다.
                }

            }

            result += 1;
            
        }

    }
    
}
