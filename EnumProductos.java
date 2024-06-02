package org.example;

/**
 * Enumeracion de los productos y sus respectivos valores
 */
public enum EnumProductos {
    /**
     * Tipo y precio de CocaCola
     */
    COCACOLA(700){
        @Override
        public Producto createProducto(int serie){
            return new CocaCola(serie);
        }
    },
    /**
     * Tipo y precio de Sprite
     */
    SPRITE(500){
        @Override
        public Producto createProducto(int serie){
            return new Sprite(serie);
        }
    },
    /**
     * Tipo y precio de Fanta
     */
    FANTA(600){
        @Override
        public Producto createProducto(int serie){
            return new Fanta(serie);
        }
    },
    /**
     * Tipo y precio de Snickers
     */
    SNICKERS(1000){
        @Override
        public Producto createProducto(int serie){
            return new Snickers(serie);
        }
    },
    /**
     * Tipo y precio de Super8
     */
    SUPER8(500){
        @Override
        public Producto createProducto(int serie){
            return new Super8(serie);
        }
    };

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

    public abstract Producto createProducto(int serie);
}
