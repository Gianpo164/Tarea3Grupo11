package org.example;

/**
 * Enumeracion de los productos y sus respectivos valores
 */
public enum EnumProductos {
    /**
     * Tipo y precio de CocaCola
     */
    COCACOLA(700),
    /**
     * Tipo y precio de Sprite
     */
    SPRITE(500),
    /**
     * Tipo y precio de Fanta
     */
    FANTA(600),
    /**
     * Tipo y precio de Snickers
     */
    SNICKERS(1000),
    /**
     * Tipo y precio de Super8
     */
    SUPER8(500);

    int precio = 0;

    /**
     * @param valor El precio de cada producto
     */
    EnumProductos(int valor) {
        precio = valor;
    }

    /**
     * Retorna el precio del producto
     * @return El precio del producto
     */
    public int getPrecio(){
        return precio;
    }
}
