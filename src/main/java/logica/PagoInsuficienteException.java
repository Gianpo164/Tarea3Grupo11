package logica;

/**
 *Excepcion que maneja un mensaje de error personalizado y devuelve una modeda. Sera utilizado en Expendedor
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Almacena la moneda devuelta
     */
    private DepositoMonedas depositoMonedas;
    private String monedas = "";;

    /**
     * Crea la excepcion para la situacion especificada
     * @param errorMessage Mensaje de error que sera entregado
     * @param m Moneda que sera devuelta
     */
    public PagoInsuficienteException(String errorMessage,DepositoMonedas m){
        super(errorMessage);
        depositoMonedas = m;
    }

    /**
     * Devuelve el mensaje de error
     * @return mensaje de error y valor de la moneda
     */
    @Override
    public String getMessage() {
        for (Moneda m: depositoMonedas.getDepositoMonedas()) {
            monedas +=" "+m.getValor();
        }
        return super.getMessage() + ", su moneda:" + monedas;
    }

}
