package logica;

/**
 * Producto Snickers
 */
public class Snickers extends Producto{

    /**
     * Crea un Snickers
     * @param serie Serie
     */
    public Snickers(int serie) {
        super(serie);
    }

    /**
     * Retorna el valor del producto
     * @return el valor del producto
     */
    @Override
    public int getValor() {
        return EnumProductos.SNICKERS.getPrecio();
    }

    /**
     * Retorna el nombre del producto
     * @return El nombre del producto
     */
    @Override
    public String consumir(){
        return "Snickers";
    }
}