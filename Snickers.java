package org.example;

/**
 * Producto Snickers
 */
public class Snickers extends Producto{

    /**
     * Crea un Snickers
     * @param x Serie
     */
    public Snickers(int x) {
        super(x);
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
     * Retorna el nombre del producto consumido
     * @return El nombre del producto consumido
     */
    @Override
    public String consumir(){
        return "snicker";
    }
}