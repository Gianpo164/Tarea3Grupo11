package logica;

/**
 * Representacion de un comprador el cual adquirira un producto en una maquina expendedora
 */
public class Comprador {

    /**
     * Compra un producto de un expendedor con una moneda, saca las monedas del deposito para calcular el vuelto y consume el producto comprado
     * @param cual Utilizado para identificar el tipo de producto que quiere comprar
     * @param exp Expendedor en el cual intentara comprar el producto
     * @throws NoHayProductoException si el producto no existe en el Expendedor
     * @throws PagoInsuficienteException si ingreso una moneda con valor menor al costo del producto
     * @throws PagoIncorrectoException si no paso un moneda
     * @throws ProductoIncorrectoException si pide un producto que no existe en el expendedor
     */
    public Comprador(int cual, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException, ProductoIncorrectoException{
        exp.comprarProducto(cual);
    }
}