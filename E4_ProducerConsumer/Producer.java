package E4_ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable {
    private Monitor monitor;

    public Producer(Monitor m) {
        this.monitor = m;
    }

    public void run() {
        String importantInfo[] = {
            "Hola como estas",
            "ando aprendiendo hilos",
            "son muy facilies y divertidos",
            "se pude mendiante la interfaz Runnable",
            "tambien con herecia desde la clase Thread",
            "todos los hilos ejecutan el metodo run()",
            "los hilos manejan prioridad",
            "se cambia desde el metodo setPriority()",
            "la prioridad es un valor entero que va de 1 a 10",
            "los hilos se pueden poner a dormir",
            "para eso uso el metodo Sleep()",
            "el tiempo de espera de un hilo va en milisegundos",
            "un hilo se puede interrumpir",
            "se usa el metodo interrupt();",
            "tanto sleep como interrupt deben ir dentro de bloque try/catch",
            "los hilos se pueden sincronizar",
            "se puede sincronizar a nivel de objeto y metodo",
            "para eso se usa la palabra reservada synchronized",
            "con el uso de hilos puedo hacer apps tipo Productor-Consumidor",
            "para eso uso una clase monitor que orquesta los hilos",
            "eso es lo que llevo y tu como estas?",
            "Creo que estaba hablando solo XD"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) 
        {
            System.out.println("\033[35mPRODUCTOR: tengo nuevo msj, notifico a Monitor\u001B[0m");
            monitor.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {}
        }
        System.out.println("\033[35mPRODUCTOR: ya no hay mas, termine\u001B[0m");
        monitor.put("FIN");
    }
}