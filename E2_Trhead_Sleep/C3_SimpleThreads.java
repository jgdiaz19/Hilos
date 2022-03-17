package E2_Trhead_Sleep;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class C3_SimpleThreads {
    
    
    
    // Muestra un mensaje precedido
    // del nombre del hilo actual
    static void mensajeHilo(String mensaje) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.format("%s: %s%n", nombreHilo, mensaje);
    }
    
    private static class MessageLoop implements Runnable {
        
        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy HH:mm:ss");
            
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
            try {
                for (int i = 0; i < arregloMensajes.length; i++) {
                    // Pausa de 2 segundos
                    Thread.sleep(2000);
                    // Imprimir mensaje
                    mensajeHilo("\033[35m " + arregloMensajes[i] + format.format(new Date()) + "\u001B[0m");
                }
            } catch (InterruptedException e) {
                mensajeHilo("\033[34m No habia terminado! \u001B[0m");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy HH:mm:ss");
        // time out de espera antes de interrumpir el proceso
        // por default 1 minuto
        long tiempoEspera = 1000 * 10;

        // Si se pasa un parametro por linea de comando se toma como segundos
        if (args.length > 0) {
            try {
                tiempoEspera = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Debe pasar un valor entero, verfique");
                System.exit(1);
            }
        }

        long tiempoInicioProceso = System.currentTimeMillis();
        Date inicio = new Date();

        mensajeHilo("\033[32m Iniciando Hilo de procesamiento de mensajes....\u001B[0m");
        mensajeHilo("\033[36m Inicio: " + format.format(inicio) +"\u001B[0m");
        
        Thread t = new Thread(new MessageLoop());
        t.start();

        mensajeHilo("\033[33m Esperando que el Hilo de procesamiento de mensajes termine...\u001B[0m");
        
        // Corremos un while infinito mientras el segundo hilo este vivo
        while (t.isAlive()) {
            mensajeHilo("\033[33m Sigo esperando...\u001B[0m");
            
            // damos una espera de 1 segundo en caso de que el proceso termine y lo
            // unimos al hilo principal
            t.join(1000);
            
            // validamos el timeout de la operacion
            if (((System.currentTimeMillis() - tiempoInicioProceso) > tiempoEspera) && t.isAlive()) {
                mensajeHilo("\033[31m Tiempo de espera agotado, se interrumpre el segundo Hilo!\u001B[0m");
                
                // generamos la interrupcion y unimos el hilo secundario con el hilo principal
                // de lo contrario el programa va a esperar idefinidamente
                t.interrupt();
                t.join();
            }
            
            // calculamos el tiempo actual del proceso
            long tiempoTranscurrido = new Date().getTime() - inicio.getTime();
            mensajeHilo("\033[32m Tiempo transcurrido: "+ TimeUnit.MILLISECONDS.toMinutes(tiempoTranscurrido) +
            " minuto(s) "+ TimeUnit.MILLISECONDS.toSeconds(tiempoTranscurrido) +" segundo(s)!\u001B[0m");
            
        }
        Date fin = new Date();
        long intervaloTiempoProceso = fin.getTime() - inicio.getTime(); 
        
        mensajeHilo("\033[32m Proceso finalizado!\u001B[0m");

        mensajeHilo("\033[34m TIEMPO TOTAL: "+ TimeUnit.MILLISECONDS.toMinutes(intervaloTiempoProceso) +
        " minuto(s) "+ TimeUnit.MILLISECONDS.toSeconds(intervaloTiempoProceso) +" segundo(s)!\u001B[0m");
        
        mensajeHilo("\033[36m Fin: " + format.format(fin) +"\u001B[0m");
    }
}
