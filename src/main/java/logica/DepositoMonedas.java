package logica;

import java.util.ArrayList;

public class DepositoMonedas extends Deposito<Moneda>{
    public DepositoMonedas(){
    }
    public int getValorTotal(){
        int x = 0;
        if (deposito.isEmpty()){
            return 0;
        }
        for (Moneda i: deposito) { //revisar
            if (i == null) {
                continue;
            }
            x += i.getValor();
        }
        return x;
    }
    public ArrayList<Moneda> getDepositoMonedas(){
        return deposito;
    }
}
