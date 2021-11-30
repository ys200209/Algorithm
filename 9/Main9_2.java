import java.util.*;

public class Main9_2 {
    public static Queue<Nodei> queue = new LinkedList<>();

    public static void main(String[] args) {

        queue.offer(new Nodei(1, 10));
        queue.offer(new Nodei(2, 20));
        queue.offer(new Nodei(2, 30));

        queue.forEach((o) -> {
            o.distance = o.getDistance()+1;
        });

        while(!queue.isEmpty()) {
            Nodei node = queue.poll();
            System.out.println(node.getName() + " : " + node.getDistance());
        }

    }
    
}

class Nodei {

    public int name;
    public int distance;

    public Nodei(int name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}
