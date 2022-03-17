package E3_Sincronizacion;

public class C2_ContadorSincronizado {
    private int c = 0;

    public  void increment() {
        c++;
    }

    public  void decrement() {
        c--;
    }

    public  int value() {
        return c;
    }

    public static void main(String[] args) {
        
        C2_ContadorSincronizado count = new C2_ContadorSincronizado();

        Thread h1 = new SubProceso_3(count);
        Thread h2 = new SubProceso_4(count);
        h1.start();
        h2.start();
    }
}
