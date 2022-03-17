package E1_Hola_Mundo;

public class C2_HelloThread extends Thread {
    public void run() {
        System.out.println("\033[32m Hola mundo desde Hilo con herencia \u001B[0m");
    }

    public static void main(String args[]) {
        (new C2_HelloThread()).start();
    }
}
