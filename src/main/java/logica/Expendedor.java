package logica;

/**
 * Representacion de una maquina expendedora
 */
public class Expendedor {
    private Deposito<Producto>[] depositos;
    private DepositoMonedas monVu;
    private DepositoMonedas monCo;
    private Producto productoComprado;
    private EnumProductos productoPedido;

    /**
     * Crear los depositos y agregarle productos
     * @param numProductos cuantos productos habra de cada tipo
     */
    public Expendedor(int numProductos) {
        depositos = new Deposito[EnumProductos.values().length];
        monVu = new DepositoMonedas();
        monCo = new DepositoMonedas();

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
    public void comprarProducto(int codigoProducto) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, ProductoIncorrectoException {
        productoComprado = null;
        productoPedido = null;
        int vuelto = 0;

        for (EnumProductos x : EnumProductos.values()) {
            if (x.codigo == codigoProducto) {
                productoPedido = x;
            }
        }

        if (productoPedido == null){
            monVu.getDepositoMonedas().addAll(monCo.getDepositoMonedas());
            monCo.getDepositoMonedas().clear();
            throw new ProductoIncorrectoException("No existe el producto pedido", monVu);
        }
        if (monCo.getDepositoMonedas().isEmpty()) {
            throw new PagoIncorrectoException("Pago incorrecto");
        }

        if (depositos[productoPedido.ordinal()].getSizeDeposito() == 0) {
            monVu.getDepositoMonedas().addAll(monCo.getDepositoMonedas());
            monCo.getDepositoMonedas().clear();
            throw new NoHayProductoException("No hay producto", monVu);
        }

        if (monCo.getValorTotal() >= productoPedido.precio){
            while (monCo.getValorTotal() - productoPedido.precio - vuelto >= 1500) {
                monVu.addObject(new Moneda1500());
                vuelto += 1500;
            }

            while (monCo.getValorTotal() - productoPedido.precio - vuelto >= 1000) {
                monVu.addObject(new Moneda1000());
                vuelto += 1000;
            }

            while (monCo.getValorTotal() - productoPedido.precio - vuelto >= 500) {
                monVu.addObject(new Moneda500());
                vuelto += 500;
            }

            while (monCo.getValorTotal() - productoPedido.precio - vuelto >= 100) {
                monVu.addObject(new Moneda100());
                vuelto += 100;
            }

            productoComprado = depositos[productoPedido.ordinal()].getObject();
            monCo.getDepositoMonedas().clear();
        }
        else {
            monVu.getDepositoMonedas().addAll(monCo.getDepositoMonedas());
            monCo.getDepositoMonedas().clear();
            throw new PagoInsuficienteException("El producto cuesta mas de lo que se entrego", monVu);
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

    public void insertarMoneda(Moneda x){
        monCo.addObject(x);
        System.out.println(x.getValor());
    }

    public Deposito getDeposito(int x){
        return depositos[x];
    }
}