package logica;

import java.util.Random;

/**
 * Enumeracion de los productos y sus respectivos valores
 */
public enum EnumProductos {
    /**
     * Precio de CocaCola
     */
    COCACOLA(1400){
        @Override
        public Producto createProducto(int serie){
            return new CocaCola(serie);
        }
    },
    /**
     * Precio de Sprite
     */
    SPRITE(1000){
        @Override
        public Producto createProducto(int serie){
            return new Sprite(serie);
        }
    },
    /**
     * Precio de Fanta
     */
    FANTA(400){
        @Override
        public Producto createProducto(int serie){
            return new Fanta(serie);
        }
    },
    /**
     * Precio de Snickers
     */
    SNICKERS(1700){
        @Override
        public Producto createProducto(int serie){
            return new Snickers(serie);
        }
    },
    /**
     * Precio de Super8
     */
    SUPER8(800){
        @Override
        public Producto createProducto(int serie){
            return new Super8(serie);
        }
    };
    private Random random =new Random();
    int precio = 0;
    public int codigo = 0;

    /**
     * @param valor El precio de cada producto
     */
    EnumProductos(int valor) {
        precio = valor;
        codigo = random.nextInt(100,1000);
    }

    /**
     * Retorna el precio del producto
     * @return El precio del producto
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * Retorna producto generado con la serie entregada
     * @param serie del producto a crear
     * @return Producto generado con la serie entregada
     */
    public abstract Producto createProducto(int serie);
}
