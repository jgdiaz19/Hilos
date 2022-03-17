package E4_ProducerConsumer;

public class C1_ProducerConsumerExample {
    public static void main(String[] args) {
        Monitor drop = new Monitor();
        Thread proudctor = new Thread(new Producer(drop));
        Thread consumidor = new Thread(new Consumer(drop));

        proudctor.start();
        consumidor.start();

        System.out.println("Main: Yo hago algo mas");
        
        
        while (proudctor.isAlive() && consumidor.isAlive()) {
            try {
                System.out.println("Main: Sigo vivo y chambeando....");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        try {
            proudctor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main: Ya terminaron los hilos, fin del programa");
    }
}
