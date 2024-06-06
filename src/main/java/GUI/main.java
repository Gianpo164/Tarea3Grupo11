package org.example.gui;

import org.example.logica.Comprador;
import org.example.logica.Expendedor;

public class main {
    public static void main(String[] args) {

        Expendedor expendedor = new Expendedor(10);

        Ventana ventana = new Ventana(expendedor);
        ventana.pack();
    }
}
