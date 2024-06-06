package logica;

/**
 * Producto que sera expenedido
 */
public abstract class Producto {
    private int serie;
    private int valor;

    /**
     * Genera un producto con la serie otorgada
     * @param x Serie del producto
     */
    public Producto(int x) {
        serie = x;
    }

    /**
     * Retorna el valor del producto
     * @return el valor del producto
     */
    public abstract int getValor();

    /**
     * Retorna la serie del producto
     * @return La serie del producto
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Retorna el nombre del producto
     * @return El nombre del producto
     */
    public abstract String consumir();
}
