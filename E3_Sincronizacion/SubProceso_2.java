package E3_Sincronizacion;

public class SubProceso_2 extends Thread{
    
    private C1_Contador contador;

    public SubProceso_2(C1_Contador objetoC) {
        contador = objetoC;
    }


    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
           
            contador.decremento();
            System.out.println("\033[33m" + nombreHilo + ": DEC. Valor de c = " + contador.value() + "\u001B[0m");
        }
    }
}
