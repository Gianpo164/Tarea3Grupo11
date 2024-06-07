package logica;

import java.util.ArrayList;

/**
 * Deposito que almacena monedas
 */
public class DepositoMonedas extends Deposito<Moneda>{
    /**
     * Genera el deposito de monedas
     */
    public DepositoMonedas(){
    }

    /**
     * Retorna la suma total del valor de las monedas
     * @return la suma total del valor de las monedas
     */
    public int getValorTotal(){
        int x = 0;
        if (deposito.isEmpty()){
            return 0;
        }
        for (Moneda i: deposito) {
            if (i == null) {
                continue;
            }
            x += i.getValor();
        }
        return x;
    }

    /**
     * Retorna el ArrayList que almacena las monedas
     * @return el ArrayList que almacena las monedas
     */
    public ArrayList<Moneda> getDepositoMonedas(){
        return deposito;
    }
}
