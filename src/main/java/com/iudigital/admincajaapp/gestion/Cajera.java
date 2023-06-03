/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.admincajaapp.gestion;

import com.iudigital.admincajaapp.producto.Producto;
import com.iudigital.admincajaapp.producto.cliente.Cliente;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author NATSU DRAGNEEL
 */
public class Cajera extends Thread {

    private String nombre;
    private JLabel caja;
    private Cliente cliente;
    private long timeStamp;

    public Cajera(String nombre, JLabel caja) {
        this.nombre = nombre;
        this.caja = caja;
    }

    @Override
    public void run() {
        procesarCompra();
    }

    public void procesarCompra() {
        String logInicio = "<html>Cajera - " + this.nombre + ": Procesando compra...<br/>"
                + "Cliente: " + this.cliente.getNombre() + "<br/>"
                + "Tiempo: " + (System.currentTimeMillis() - this.timeStamp) / 1000 + "</html>";

        caja.setText(logInicio);
        int conCliente = 1;

        for (Producto producto : cliente.getProductos()) {
            this.esperarXsegundo();

            float costoTotal = producto.getCantidad() * producto.getPrecio();
            String logProcesamiento = "<html>Procesando el producto " + conCliente + "...<br/>"
                    + "Nombre producto: " + producto.getNombre() + "<br/>"
                    + "Precio producto: " + producto.getPrecio() + "<br/>"
                    + "Cantidad productos: " + producto.getCantidad() + "<br/>"
                    + "Costo total: " + costoTotal + "<br/>"
                    + "Tiempo: " + (System.currentTimeMillis() - this.timeStamp) / 1000 + " seg"+ "</html>";

            caja.setText(logProcesamiento);
        }
    }

    public void esperarXsegundo() {
        try {
            Cajera.sleep(1000);
        } catch (InterruptedException e) {
            // TODO: implementar retorno del catch
            Thread.currentThread().interrupt();
        }
    }

    public void setInfoProcesoCaja(Cliente cliente, long timeStamp) {
        this.cliente = cliente;
        this.timeStamp = timeStamp;
    }
}
