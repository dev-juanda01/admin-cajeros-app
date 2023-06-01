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

    public Cajera(String nombre, JLabel caja) {
        this.nombre = nombre;
        this.caja = caja;
    }
    
    @Override
    public void run() {
//        procesarCompra(cliente, MIN_PRIORITY);
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp) {
        String logInicio = "Cajera - " + this.nombre + ": Procesando compra...\n" 
                + "Cliente: " + cliente.getNombre() 
                + "Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000;
        
        caja.setText(logInicio);
        int conCliente = 1;
        
        for(Producto producto : cliente.getProductos()) {
            this.esperarXsegundo();
            
            float costoTotal = producto.getCantidad() * producto.getPrecio();
            String logProcesamiento = "Procesando el producto " + conCliente + "...\n" 
                    + "Nombre producto: " + producto.getNombre() + "\n" 
                    + "Precio producto: " + producto.getPrecio() + "\n" 
                    + "Cantidad productos: " + producto.getCantidad() + "\n" 
                    + "Costo total: " + costoTotal + "\n" 
                    + "Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000;
        }
    }
    
    public void esperarXsegundo() {
        try {
            Cajera.sleep(1000);
        } catch (InterruptedException e) {
            // TODO: implementar retorno del catch
            Thread.currentThread().interrupt();
        };
    }
}
