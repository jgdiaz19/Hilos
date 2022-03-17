package E0_Introduccion.Concurrente;

public class CajeraThread extends Thread {
    private String nombre;
	private Cliente cliente;
	private long initialTime;

    public CajeraThread(String s, Cliente cli, long t) {
        nombre = s;
        cliente = cli;
        initialTime = t;
    }

    public void run() {

		System.out.println("\u001B[33m" + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " 
					+ this.cliente.getNombre() + " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg\u001B[0m");

		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) { 
			this.esperarXsegundos(cliente.getCarroCompra()[i]); 
			System.out.println("\u001B[36mProcesado el producto " + (i + 1) 
			+ " del cliente " + this.cliente.getNombre() + "->Tiempo: " 
			+ (System.currentTimeMillis() - this.initialTime) / 1000 
			+ "seg\u001B[0m");
		}

		System.out.println("\u001B[32m" + this.nombre + " HA TERMINADO DE PROCESAR " 
						+ this.cliente.getNombre() + " EN EL TIEMPO: " 
						+ (System.currentTimeMillis() - this.initialTime) / 1000 
						+ "seg\u001B[0m");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
