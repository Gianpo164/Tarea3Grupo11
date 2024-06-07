package logica;

/**
 * Producto Sprite
 */
public class Sprite extends Producto{

    /**
     * Crea una Sprite
     * @param serie Serie
     */
    public Sprite(int serie){
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
        return "Sprite";
    }
}