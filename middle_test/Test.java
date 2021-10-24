abstract class Animal {
    String a = " is ani";
    abstract void look();
    void show() {
        System.out.println("Zoo");
    }
}

class Chic extends Animal {
    Chic() {
        look();
    }
    void look() {
        System.out.println("Chic" + a);
    }
    void display() {
        System.out.println("two wings");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Chic();
        a.show();
    }
}
