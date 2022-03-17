package E3_Sincronizacion;

public class SubProceso_4 extends Thread {
    
    private C2_ContadorSincronizado contSinc;

    public SubProceso_4(C2_ContadorSincronizado objContador) {
        contSinc = objContador;
    }

    public void run() {
        String nombreHilo = Thread.currentThread().getName();

        synchronized(contSinc){
            for (int i = 0; i < 100; i++) {
                contSinc.decrement();
                System.out.println("\033[33m" + nombreHilo + ": DEC. Valor de c = " + contSinc.value() + "\u001B[0m");
            }
        }
    }
}
