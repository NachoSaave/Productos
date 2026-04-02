package com.Producto.Productos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Producto.Productos.Modelo.Producto;
import com.Producto.Productos.Repository.RepositoryProducto;
import com.Producto.Productos.Service.ServiceProducto;


@RestController
@RequestMapping("/api/v1/productos")
public class ControllerProducto {
@Autowired
private ServiceProducto serviciopro;
private RepositoryProducto RepositoryProducto;
public ControllerProducto(){
    RepositoryProducto=new RepositoryProducto();
}

@GetMapping
public List<Producto> listarProductos(){
    return serviciopro.getProductos();
}
@PostMapping
    public Producto guardarProducto(@RequestBody Producto pro) {
        return serviciopro.guardarPro(pro);
    }
@GetMapping("/{id}")
    public Producto obtenerLibroPorId(@PathVariable int id) {
        return serviciopro.getProductoid(id);
    }
@PutMapping("/{id}")
    public Producto actualizarLibro(@PathVariable int id, @RequestBody Producto pro) {
        pro.setId(id);
        return serviciopro.ActualizarPro(pro);
    }
@DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) {
        return serviciopro.eliminarProducto(id);
    }
@GetMapping("/tipo/{tipo}")
public List <Producto> getPorTipo(@PathVariable String tipo) {
    return serviciopro.filtraTipo(tipo);
}
@GetMapping("/color/{color}")
public List <Producto> getPorColor(@PathVariable String color) {
    return serviciopro.filtraColor(color);
}

}
