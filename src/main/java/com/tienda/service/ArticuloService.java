/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

/**
 *
 * @author isaac
 */
public interface ArticuloService {
    //se definen los 4 metodos de un CRUD
    //Create Read Update Delete
    
    
    //retorna la lista de articulos
    public List<Articulo> getArticulos(boolean activos);
    
    //Dado un articulo.id se busca en la tabla y 
    // se retorna todo el objeto Articulo
    public Articulo getArticulo(Articulo articulo);
    
    //Si articulo.id tiene un valor se busca y e actualiza
    // Su articulo.id No tiene valor, se inserta el objeto en la tabla
    public void save(Articulo articulo);
    
    //elimina el registro que tiene el id igual a articulo.id
    public void delete(Articulo articulo);

   
}
