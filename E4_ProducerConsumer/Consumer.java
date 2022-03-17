package E4_ProducerConsumer;

import java.util.Random;

public class Consumer implements Runnable {
    private Monitor drop;

    public Consumer(Monitor drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take(); !message.equals("FIN"); message = drop.take()) {
            System.out.format("\033[32mCONSUMIDOR: Mensaje recibido ->%s%n", message + "\u001B[0m");
            try {
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\033[32mCONSUMIDOR: Mensaje recibido ->FIN\u001B[0m");
    }
}