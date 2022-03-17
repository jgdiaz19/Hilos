package E2_Trhead_Sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C1_SleepMessages {
    public static void main(String args[]) throws InterruptedException {
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

        for (int i = 0; i < arregloMensajes.length; i++) {
            // Pause for 4 seconds
            Thread.sleep(2000);
            // Print a message
            System.out.println(arregloMensajes[i] + format.format(new Date()));
        }
    }
}
