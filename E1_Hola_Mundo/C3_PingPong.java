package E1_Hola_Mundo;

public class C3_PingPong extends Thread {
    
    private String word;
    
    public C3_PingPong(String s) {
        word = s;
    }

    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.print(word);
        }
    }

    public static void main(String[] args) {
        Thread h1 = new C3_PingPong("\033[32m Ping \u001B[0m");
        Thread h2 = new C3_PingPong("\033[33m Pong \u001B[0m");
         h1.setPriority(1);
         h2.setPriority(10);
        h1.start();
        h2.start();
    }
}
