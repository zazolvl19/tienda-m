/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author isaac
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
    //se implementan los 4 metodos de un CRUD
    //Create Read Update Delete mediante CategoriaDao
    
    //Se utiliza ina anotacion autowired para el objeto CategoriaDao
    //Si ya se esta en memoria se use ese... Sino se crea (singleton)
    @Autowired
    private CategoriaDao categoriaDao;
    
    
    //retorna la lista de categorias
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)categoriaDao.findAll(); 
        
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
        
    }
    
    //Dado un categoria.id se busca en la tabla y 
    // se retorna todo el objeto Categoria
    @Override
    @Transactional(readOnly = true)    
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    //Si categoria.id tiene un valor se busca y e actualiza
    // Si categoria.id No tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional    
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }
    
    //elimina el registro que tiene el id igual a categoria.id
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);        
    }

}
