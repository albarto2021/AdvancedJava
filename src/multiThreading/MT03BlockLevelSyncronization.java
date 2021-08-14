package multiThreading;

public class MT03BlockLevelSyncronization {
    public static void main(String[] args) throws InterruptedException {
        Parantez p1 = new Parantez();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=5; i++){
                    p1.parantezKoy();
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=5; i++){
                    p1.parantezKoy();
                }
            }
        });
        long basla = System.currentTimeMillis();
        th1.start();
        th2.start();

        th1.join();
        th2.join();

        long bitir = System.currentTimeMillis();
        System.out.println("Toplam Sure:" + (bitir-basla));
    }
}

class Parantez{
    public void parantezKoy(){
        // Block-Level Synchronization
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println(" ");
        }

        for(int i=1; i<=10; i++){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}