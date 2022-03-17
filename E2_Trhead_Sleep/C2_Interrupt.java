package E2_Trhead_Sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C2_Interrupt implements Runnable {

    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy HH:mm:ss");
        // Se procesa un arreglo de 17 elementos, cada elemento tarda 500ms en procesarce, t=8.5s
        String arregloMensajes[] = { "TEMP|25.17; ", 
                                     "TEMP|24.32; ", 
                                     "TEMP|25.39; ",
                                     "TEMP|24.32; ", 
                                     "TEMP|23.39; ",
                                     "TEMP|25.32; ", 
                                     "TEMP|24.39; ",
                                     "TEMP|25.32; ", 
                                     "TEMP|22.39; ",
                                     "TEMP|25.64; ",
                                     "TEMP|25.68; ",
                                     "TEMP|24.09; ",
                                     "TEMP|23.75; ",
                                     "TEMP|23.99; ",
                                     "TEMP|24.45; ",
                                     "TEMP|25.62; ",
                                     "TEMP|24.12; " };

        for (int i = 0; i < arregloMensajes.length; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { //Capturamos una excepcion en caso de que se interrumpa el hilo
                try {
                    //Podemos hacer algun proceso extra dentro del bloque catch, inclusive interaccion con usuario
                    System.out.println("\033[31m Hilo interumpido \u001B[0m");
                    Thread.sleep(1000);
                    System.out.println("\033[32m Puedo despertar en ... 3");
                    Thread.sleep(1500);
                    System.out.println(" Puedo despertar en ... 2");
                    Thread.sleep(1000);
                    System.out.println(" Puedo despertar en ... 1 \u001B[0m");
                    Thread.sleep(1000);
                    System.out.println("\033[36m Presione cualquier tecla para continuar el proceso ...  \u001B[0m");
                    (new Scanner(System.in)).nextLine();
                    
                    
                } catch (InterruptedException ex) { }

            }
            // imprimir valores
            System.out.println(i+1 + ". " + arregloMensajes[i] + format.format(new Date()));

        }
    }
    
    public static void main(String[] args) {
        Thread hilo = new Thread(new C2_Interrupt());
        hilo.start();
        try {
            Thread.sleep(3000);
            System.out.println("\033[33m Voy a intrrumpir el hilo en dos segundos.. \u001B[0m");
            Thread.sleep(1000);
            System.out.println("\033[33m 1... \u001B[0m");
            Thread.sleep(1000);
            System.out.println("\033[33m 2... \u001B[0m");
            Thread.sleep(1000);
            System.out.println("\033[35m YA!!... \u001B[0m");
            //transcurrido t=6 realizamos la interrupcion

            hilo.interrupt();
            

        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        
    }
    
}
