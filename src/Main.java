public class Main {
    public static void main(String[] args) {
        A a = new A();
        a = null; // memory of A() now unreachable
        System.gc(); // optional since the gc is invoked periodically
        while (true);
    }
}


class A {
    public void finalize() {
        System.out.println("finalize");
    }
}