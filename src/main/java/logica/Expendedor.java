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
    private Producto productoDeposito;
    private Producto productoRetirado = new CocaCola(0);
    private int vuelto;

    /**
     * Crear los depositos y agregarle productos
     * @param numProductos cuantos productos habra de cada tipo
     */
    public Expendedor(int numProductos) {
        depositos = new Deposito[EnumProductos.values().length];
        monVu = new DepositoMonedas();
        monCo = new DepositoMonedas();

        int serie = 0;
        for(EnumProductos producto : EnumProductos.values()){
            depositos[producto.ordinal()] = new Deposito<>();
            for (int i = 100 + serie; i < 100 + serie + numProductos; i++) {
                depositos[producto.ordinal()].addObject(producto.createProducto(i));
            }
            serie += 100;
        }
    }

    /**
     * Se asegura de que el producto y el vuelto sean el correcto
     * @param codigoProducto para seleccionar el producto a comprar
     * @throws NoHayProductoException si no quedan productos del que se pide
     * @throws PagoIncorrectoException si no se ingresa una moneda
     * @throws PagoInsuficienteException si con la moneda ingresada no alcanza a comprar el producto
     * @throws ProductoIncorrectoException si el producto que se pide no existe en la expendedora
     */
    public void comprarProducto(int codigoProducto) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, ProductoIncorrectoException {
        productoComprado = null;
        productoPedido = null;

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
            vuelto = 0;

            productoComprado = depositos[productoPedido.ordinal()].getObject(0);
            monCo.getDepositoMonedas().clear();
        }
        else {
            monVu.getDepositoMonedas().addAll(monCo.getDepositoMonedas());
            monCo.getDepositoMonedas().clear();
            throw new PagoInsuficienteException("El producto cuesta mas de lo que se entrego", monVu);
        }
    }

    /**
     * Remplaza el producto del productoDeposito por el del productoComprado
     */
    public void productoComprado(){
        if (productoComprado != null) {
            productoDeposito = productoComprado;
            productoComprado = null;
        }
    }

    /**
     * Remplaza el producto del productoRetirado por el del productoDeposito
     */
    public void recogerProducto(){
        if (productoDeposito != null) {
            productoRetirado = productoDeposito;
            productoDeposito = null;
        }
    }

    /**
     * Retorna el producto del productoDeposito
     * @return El producto del productoDeposito
     */
    public Producto getProductoDeposito() {
        return productoDeposito;
    }

    /**
     * Retorna el producto del productoRetirado
     * @return El producto del productoRetirado
     */
    public Producto getProductoRetirado(){
        return productoRetirado;
    }

    /**
     * Retorna el nombre del producto que el usuario retiro
     * @return El nombre del producto que el usuario retiro
     */
    public String getNombreProducto(){
        if (productoRetirado == null){
            return "";
        }
        return productoRetirado.consumir();
    }
    /**
     * Retorna el valor de la moneda en el indice x del depositoDeMonedas
     * @param x Almacina el indice
     * @return El valor de la moneda en el indice x del depositoDeMonedas
     */
    public int getVuelto(int x) {
        Moneda m = monVu.getObject(x);
        return m.getValor();
    }

    /**
     * Ingresa una Moneda al deposito que almacena las monedas para comprar productos
     * @param moneda Moneda ingresada
     */
    public void insertarMoneda(Moneda moneda){
        monCo.addObject(moneda);
        System.out.println("Serie moneda insertada: " + moneda.getSerie());
    }

    /**
     * Retorna el deposito con el indice pedido
     * @param x indice
     * @return El deposito con el indice pedido
     */
    public Deposito getDeposito(int x){
        return depositos[x];
    }

    /**
     * Retorna el deposito que almacena las monedas para comprar productos
     * @return El deposito que almacena las monedas para comprar productos
     */
    public DepositoMonedas getMonCo(){
        return monCo;
    }

    /**
     * Retorna el deposito que almacena las monedas de vuelto
     * @return El deposito que almacena las monedas de vuelto
     */
    public DepositoMonedas getMonVu(){
        return monVu;
    }
}