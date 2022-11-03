/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author isaac
 */
public interface CategoriaService {
    //se definen los 4 metodos de un CRUD
    //Create Read Update Delete
    
    
    //retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
    
    //Dado un categoria.id se busca en la tabla y 
    // se retorna todo el objeto categoria
    public Categoria getCategoria(Categoria categoria);
    
    //Si categoria.id tiene un valor se busca y e actualiza
    // Su categoria.id No tiene valor, se inserta el objeto en la tabla
    public void save(Categoria categoria);
    
    //elimina el registro que tiene el id igual a categoria.id
    public void delete(Categoria categoria);
}
