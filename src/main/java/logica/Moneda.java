package logica;

import java.util.Random;

/**
 * Forma de pago para el expendedor
 */
public abstract class Moneda implements Comparable<Moneda> {
    Random random = new Random();

    private int numeroDeSerie;
    /**
     * Genera una moneda y un numero de serie aleatorio
     */
    public Moneda() {
        numeroDeSerie = random.nextInt(100000,1000000);
    }
    /**
     * Retorna la serie de la moneda
     * @return la serie de la moneda
     */
    public int getSerie() {
        return numeroDeSerie;
    }

    /**
     * Retorna el valor de la moneda
     * @return El valor de la moneda
     */
    public abstract int getValor();

    /**
     * Compara dos monedas y dice si es mayor, igual o menor
     * @param m la moneda con la cual se va a comparar
     * @return un numero dependiendo de la comparacion
     */
    public int compareTo(Moneda m) {
        if (this.getValor() > m.getValor())
            return 1;

        else if (this.getValor() < m.getValor())
            return -1;

        else
            return 0;
    }
}