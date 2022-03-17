package E0_Introduccion.Concurrente;

public class Cliente {
    private String nombre;
	private int[] carroCompra;

    public Cliente(String s, int[] c) {
        nombre = s;
        carroCompra = c;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }
    public String getNombre() {
        return nombre;
    }
    public int[] getCarroCompra() {
        return carroCompra;
    }
}
