package logica;

/**
 * Producto CocaCola
 */
public class CocaCola extends Producto{

    /**
     * Crea una CocaCola
     * @param serie Serie del producto
     */
    public CocaCola(int serie){
        super(serie);
    }

    /**
     * Retorna el valor del producto
     * @return El valor del producto
     */
    @Override
    public int getValor() {
        return EnumProductos.COCACOLA.getPrecio();
    }

    /**
     * Retorna el nombre del producto
     * @return El nombre del producto
     */
    @Override
    public String consumir(){
        return "CocaCola";
    }
}