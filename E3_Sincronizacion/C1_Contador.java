package E3_Sincronizacion;

public class C1_Contador {
    private int c = 0;

    public void incremento() {
        c++;
    }

    public void decremento() {
        c--;
    }

    public int value() {
        return c;
    }

    

    public static void main(String[] args) {
        
        C1_Contador count = new C1_Contador();

        Thread h1 = new SubProceso_1(count);
        Thread h2 = new SubProceso_2(count);
        h1.start();
        h2.start();
    }

}