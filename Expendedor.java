package org.example;

/**
 * Representacion de una maquina expendedora
 */
public class Expendedor {
    private Deposito<Producto>[] depositos;
    private Deposito<Moneda> monVu;
    private int precioProducto;
    private Producto p;

    /**
     * Crear los depositos y agregarle productos
     * @param numProductos cuantos productos habra de cada tipo
     */
    public Expendedor(int numProductos) {
        depositos = new Deposito[EnumProductos.values().length];
        monVu = new Deposito<>();

        for(EnumProductos producto : EnumProductos.values()){
            depositos[producto.ordinal()] = new Deposito<>();
            int serie = 0;
            for (int i = 100 + serie; i < 100 + numProductos; i++) {
                depositos[producto.ordinal()].addObject(producto.createProducto(i));
            }
            serie += 100;
        }
    }

    /**
     * Se asegura de que el producto y el vuelto sean el correcto
     * @param m para corroborar que se ingreso el dinero suficiente para efectuar la compra
     * @param producto para seleccionar el producto a comprar
     * @return el producto pedido
     * @throws NoHayProductoException si no quedan productos del que se pide
     * @throws PagoIncorrectoException si no se ingresa una moneda
     * @throws PagoInsuficienteException si con la moneda ingresada no alcanza a comprar el producto
     * @throws ProductoIncorrectoException si el producto que se pide no existe en la expendedora
     */
    public void comprarProducto(Moneda m, EnumProductos producto) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, ProductoIncorrectoException {
        p = null;
        if (producto == null){
            throw new ProductoIncorrectoException("No existe el producto pedido", m);
        }
        if (m == null) {
            throw new PagoIncorrectoException("Pago incorrecto");
        }

        int eleccion = producto.ordinal();

        p = depositos[eleccion].getObject();

        if (p == null) {
            monVu.addObject(m);
            throw new NoHayProductoException("No hay producto", m);
        } else
            precioProducto = p.getValor();

        if (m.getValor() >= precioProducto){
            for (int i = 0; m.getValor() > precioProducto + i; i += 100) {
                monVu.addObject(new Moneda100());
            }
        }
        else {
            throw new PagoInsuficienteException("El producto cuesta mas de lo que se entrego", m);
        }
    }

    public Producto getProductoComprado(){
        Producto p = productoComprado;
        productoComprado = null;
        return p;
    }
    /**
     * Saca las monedas del deposito de monedas
     * @return el vuelto que se genera en la compra
     */
    public Moneda getVuelto() {
        return monVu.getObject();
    }
}