/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.admincajaapp.producto.cliente;

import java.util.List;
import com.iudigital.admincajaapp.producto.Producto;
import java.util.ArrayList;

/**
 *
 * @author NATSU DRAGNEEL
 */
public class Cliente {
    private final String nombre;
    private final String codigo;
    private List<Producto> productos = new ArrayList<>();

    public Cliente(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    public void setProductos(Producto producto) {
        this.productos.add(producto);
    }
    
}
