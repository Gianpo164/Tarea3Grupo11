package logica;

/**
 * Producto Sprite
 */
public class Sprite extends Producto{

    /**
     * Crea una Sprite
     * @param x Serie
     */
    public Sprite(int x){
        super(x);
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
     * Retorna el nombre del producto consumido
     * @return El nombre del producto consumido
     */
    @Override
    public String consumir(){
        return "Sprite";
    }
}