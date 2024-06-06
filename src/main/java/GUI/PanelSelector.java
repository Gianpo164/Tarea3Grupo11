package org.example.gui2;

import org.example.logica.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSelector extends JPanel {
    Pantalla pantalla;
    private Comprador comprador;
    static String codigo;


    public PanelSelector(Expendedor expendedor){
        setBounds(366,29,127,286);
        codigo = "";
        setOpaque(false);
        setLayout(null);

        pantalla = new Pantalla();
        TecladoNumerico teclado = new TecladoNumerico();
        add(teclado);
        add(pantalla);


        teclado.CancelarCompra.addMouseListener(new MouseAdapter() {
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
        teclado.Comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                try {
                    comprador = new Comprador(Integer.valueOf(codigo),expendedor);;
                } catch (NoHayProductoException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (ProductoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                codigo = "";
                pantalla.setText(codigo);

            }
        });
    }
    public static String getCodigo(){
        return codigo;
    }
}
