package org.example;

/**
 * Producto Fanta
 */
public class Fanta extends Producto{

    /**
     * Crea una Fanta
     * @param x Serie
     */
    public Fanta(int x){
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
        return "fanta";
    }
}