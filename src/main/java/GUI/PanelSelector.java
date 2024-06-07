package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSelector extends JPanel {
    private Pantalla pantallaCodigo;
    private Comprador comprador;
    static String codigo;


    public PanelSelector(Expendedor expendedor,PanelExpendedor panelExpendededor){

        setBounds(366,29,127,286);
        codigo = "";
        setOpaque(false);
        setLayout(null);

        pantallaCodigo = new Pantalla();
        TecladoNumerico teclado = new TecladoNumerico();
        add(teclado);
        add(pantallaCodigo);


        teclado.cancelarCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                codigo = "";
                pantallaCodigo.setText(codigo);
            }
        });
        for (int i = 0; i < 10; i++) {
            final int numero = i; // Variable final para usar dentro del ActionListener
            teclado.numeros[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (codigo.length() < 3) {
                        codigo += numero;
                        pantallaCodigo.setText(codigo);
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
                    JOptionPane.showMessageDialog(null, exc.getMessage() , "Error de pago", JOptionPane.ERROR_MESSAGE);
                }
                expendedor.productoComprado();
                codigo = "";
                pantallaCodigo.setText(codigo);
                panelExpendededor.repaint();
            }
        });
    }
    public static String getCodigo(){
        return codigo;
    }
}
