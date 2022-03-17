package E3_Sincronizacion;

public class SubProceso_1 extends Thread {


    private C1_Contador contador;

    public SubProceso_1(C1_Contador objetoC) {
        contador = objetoC;
    }

    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            contador.incremento();
            
            System.out.println("\033[32m" + nombreHilo + ": INC. Valor de c = " + contador.value() + "\u001B[0m");
        }
    }
}