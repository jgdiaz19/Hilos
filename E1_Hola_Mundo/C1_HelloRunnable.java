package E1_Hola_Mundo;

public class C1_HelloRunnable implements Runnable{
    public void run() {
        System.out.println("\033[32m Hola mundo desde Hilo con interfaz Runnable! \u001B[0m");
    }
    public static void main(String[] args) {
        (new Thread(new C1_HelloRunnable())).start();
    }
}
