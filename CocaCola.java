package org.example;

/**
 * Producto CocaCola
 */
public class CocaCola extends Producto{

    /**
     * Crea una CocaCola
     * @param x Serie
     */
    public CocaCola(int x){
        super(x);
    }

    /**
     * Retorna el valor del producto
     * @return el valor del producto
     */
    @Override
    public int getValor() {
        return EnumProductos.COCACOLA.getPrecio();
    }

    /**
     * Retorna el nombre del producto consumido
     * @return El nombre del producto consumido
     */
    @Override
    public String consumir(){
        return "cocacola";
    }
}