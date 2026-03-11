public class Main {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();

        System.out.println("Cores: " + cores);

        var t = new MyT(10);
        var op = new MyTt("lolbert");
        var titus = new Thread(op);
        t.start();
        titus.start();
        t.join(); // main waits until 't' returned from its run method - comment: both wait simultaneously
        titus.join(); // join order is irrelevant IF both were started before
        Thread.sleep(3000);
        System.out.println("Main finished");
    }
}

class MyTt implements Runnable {
    String lolita;

    public MyTt(String passme) {
        this.lolita = passme + "postfix";
    }

    @Override
    public void run() {
        System.out.println(lolita + " started");

        try {
            Thread.sleep(6500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(lolita + " finished");
    }
}

class MyT extends Thread {
    int prop;

    public MyT(int prop) {
        this.prop = prop;
    }

    @Override
    public void run() {
        System.out.println("Prop: " + prop);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished waiting");
    }
}