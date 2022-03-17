package E3_Sincronizacion;

public class C3_PingPongSync extends Thread {
    private String word;
    
    public C3_PingPongSync(String s) {
        word = s;
    }

    public void run(){
        synchronized(getClass()){
            for (int i = 0; i < 300000; i++) {
                System.out.print(word);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.flush();
                getClass().notifyAll();
                
                try {
                    getClass().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            getClass().notifyAll();
        }
    }

    public static void main(String[] args) {
        Thread h1 = new C3_PingPongSync("\033[32m Ping \u001B[0m");
        Thread h2 = new C3_PingPongSync("\033[33m Pong \u001B[0m");
        h1.start();
        h2.start();
    }
}
