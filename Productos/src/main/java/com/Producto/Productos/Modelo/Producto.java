package com.Producto.Productos.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int id;
    private String nombre;
    private String sku;
    private int precio;
    private int stock;
    private String color;
    private String tipoProducto;
    private Boolean activo;
}
