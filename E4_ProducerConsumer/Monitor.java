package E4_ProducerConsumer;

public class Monitor {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                System.out.println("\033[33mMONITOR: vacio, espero...\u001B[0m");
                wait();
            } catch (InterruptedException e) {
                System.out.println("MONITOR: interrupcion en TAKE()");
            }
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        System.out.println("\033[36mMONITOR: Notifico a Consumidor\u001B[0m");
        
        return message;
    }
    
    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("MONITOR: interrupcion en PUT()");
            }
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        System.out.println("\033[36mMONITOR: Llego mnsj de Productor\u001B[0m");
        notifyAll();
    }
}
