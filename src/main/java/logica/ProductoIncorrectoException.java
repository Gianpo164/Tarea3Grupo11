package logica;

/**
 * Excepcion que maneja un mensaje de error personalizado. Sera utilizado en Expendedor
 */
public class ProductoIncorrectoException extends Exception{
    private DepositoMonedas depositoMonedas;
    private String monedas = "";

    /**
     * Crea la excepcion para la situacion especificada
     * @param errorMessage Mensaje de error que sera entregado
     * @param depMonedas Deposito de monedas utilizado para devolver el valor de las monedas
     */
    public ProductoIncorrectoException(String errorMessage, DepositoMonedas depMonedas){
        super(errorMessage);
        depositoMonedas = depMonedas;
    }

    /**
     * Retorna el mensaje de error
     * @return el mensaje de error
     */
    @Override
    public String getMessage() {
        for (Moneda m: depositoMonedas.getDepositoMonedas()) {
            monedas +=" "+m.getValor();
        }
        return super.getMessage() + ", sus monedas:" + monedas;
    }
}