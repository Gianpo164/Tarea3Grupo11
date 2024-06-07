package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSelector extends JPanel {
    private PanelDepositoMonedas panelDepositoMonedas;
    private PanelVueltoExpendedor panelVueltoExpendedor;
    private Pantalla pantalla;
    private Comprador comprador;
    static String codigo;


    public PanelSelector(Expendedor expendedor,PanelVueltoExpendedor panelVueltoExpendedor, PanelDepositoMonedas panelDepositoMonedas){

        this.panelDepositoMonedas = panelDepositoMonedas;
        this.panelVueltoExpendedor = panelVueltoExpendedor;
        setBounds(366,29,127,286);
        codigo = "";
        setOpaque(false);
        setLayout(null);

        pantalla = new Pantalla();
        TecladoNumerico teclado = new TecladoNumerico();
        add(teclado);
        add(pantalla);


        teclado.cancelarCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                codigo = "";
                pantalla.setText(codigo);
            }
        });
        for (int i = 0; i < 10; i++) {
            final int numero = i; // Variable final para usar dentro del ActionListener
            teclado.numeros[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (codigo.length() < 3) {
                        codigo += numero;
                        pantalla.setText(codigo);
                    }
                }
            });
        }
        teclado.comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                try {
                    if (codigo == ""){
                        codigo = "999999";
                    }
                    comprador = new Comprador(Integer.valueOf(codigo),expendedor);;
                } catch (PagoIncorrectoException | ProductoIncorrectoException | PagoInsuficienteException | NoHayProductoException exc) {
                    System.out.println(exc.getMessage());
                }
                System.out.println(expendedor.getMonVu().getSizeDeposito());
                System.out.println(expendedor.getValorVuelto());
                expendedor.getProductoComprado();
                codigo = "";
                pantalla.setText(codigo);
                panelDepositoMonedas.getMonedasIngresadas().repaint();
                panelVueltoExpendedor.repaint();

            }
        });
    }
    public static String getCodigo(){
        return codigo;
    }
}
