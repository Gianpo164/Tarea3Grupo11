package logica;

/**
 * Producto Fanta
 */
public class Fanta extends Producto{

    /**
     * Crea una Fanta con la serie ingresada
     * @param serie Serie
     */
    public Fanta(int serie){
        super(serie);
    }

    /**
     * Retorna el valor del producto
     * @return el valor del producto
     */
    @Override
    public int getValor() {
        return EnumProductos.SPRITE.getPrecio();
    }

    /**
     * Retorna el nombre del producto
     * @return El nombre del producto
     */
    @Override
    public String consumir(){
        return "Fanta";
    }
}