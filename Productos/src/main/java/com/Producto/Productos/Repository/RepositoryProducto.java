package com.Producto.Productos.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Producto.Productos.Modelo.Producto;



@Repository
public class RepositoryProducto {
private List<Producto> listaProductos =new ArrayList<>();

public List<Producto> obteneProductos(){
    return listaProductos;
}


public Producto buscarPorId(int id){
    for(Producto p : listaProductos){
        if(p.getId()==id){
            return p;
        }
    }
    return null;
}
 public Producto guardar(Producto pro) {
        listaProductos.add(pro);
        return pro;
    }

public Producto actualizar(Producto p) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == p.getId()) {
                id = p.getId();
                idPosicion = i;
            }
        }
        Producto producto1=new Producto();
        producto1.setId(id);
        producto1.setNombre(p.getNombre());
        producto1.setSku(p.getSku());
        producto1.setPrecio(p.getPrecio());
        producto1.setStock(p.getStock());
        producto1.setColor(p.getColor());
        producto1.setTipoProducto(p.getTipoProducto());
        producto1.setActivo(p.getActivo());

        listaProductos.set(idPosicion, producto1);
        return producto1;
    }

public void eliminar(int id) {
    Producto p = buscarPorId(id);
    if (p != null) {
        listaProductos.remove(p);
        }

}

public List<Producto>filtraTipo(String tipo){
    List<Producto> listafiltrar=new ArrayList<>();
    for (Producto p: listaProductos){
        if(p.getTipoProducto().equals(tipo)){
            listafiltrar.add(p);
        }
    }
    return listafiltrar;
}

public List<Producto>filtraColor(String color){
    List<Producto> listafiltrar=new ArrayList<>();
    for (Producto p: listaProductos){
        if(p.getColor().equals(color)){
            listafiltrar.add(p);
        }
    }
    return listafiltrar;
}
}
