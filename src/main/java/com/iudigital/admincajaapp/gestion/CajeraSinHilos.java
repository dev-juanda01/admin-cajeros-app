
package com.iudigital.admincajaapp.gestion;
import com.iudigital.admincajaapp.producto.cliente.Cliente;
import com.iudigital.admincajaapp.producto.Producto;
import javax.swing.JLabel;

public class CajeraSinHilos {
    private String nombre;
    private JLabel caja;
    private Cliente cliente;
    private long timestamp;

    public CajeraSinHilos(String nombre, JLabel caja) {
        this.nombre = nombre;
        this.caja = caja;
    }
    
        
    public CajeraSinHilos() {
    }
    
    
    public void procesarCompra(){
        String logInicio = "<html>CajeraSinHilos - " + this.nombre + ": Procesando compra... <br/>"
                + "Cliente: " + this.cliente.getNombre() + "<br/>"
                + "Tiempo: " + (System.currentTimeMillis() - this.timestamp) / 1000 + "</html>";
        
        caja.setText(logInicio);
        int conCliente = 1;
        
        
        for (Producto producto : cliente.getProductos()) {
            
            float costoTotal = producto.getCantidad() * producto.getPrecio();
            String logProcesamiento = "<html>Porcesando el producto " + conCliente + "...<br/>"
                    + "Nombre producto: " + producto.getNombre() + "<br/>"
                    + "Precio producto: " + producto.getPrecio() + "<br/>"
                    + "Cantidad productos: " + producto.getCantidad() + "<br/>"
                    + "Costo Total: " + costoTotal + "<br/>"
                    + "Tiempo: " + (System.currentTimeMillis() - this.timestamp) / 1000 + " seg" + "</html>";
            
            caja.setText(logProcesamiento);
        }        
    } 
    
     public void setInfoProcesoCaja(Cliente cliente, long timeStamp) {
        this.cliente = cliente;
        this.timestamp = timeStamp;
    }
}
 