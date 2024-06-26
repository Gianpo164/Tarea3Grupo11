package logica;

/**
 * Producto Super8
 */
public class Super8 extends Producto{

    /**
     * Crea una Super8
     * @param serie Serie
     */
    public Super8(int serie) {
        super(serie);
    }

    /**
     * Retorna el valor del producto
     * @return el valor del producto
     */
    @Override
    public int getValor() {
        return EnumProductos.SUPER8.getPrecio();
    }

    /**
     * Retorna el nombre del producto
     * @return El nombre del producto
     */
    @Override
    public String consumir(){
        return "Super8";
    }
}