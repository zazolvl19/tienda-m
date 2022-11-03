/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author isaac
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {
    //se implementan los 4 metodos de un CRUD
    //Create Read Update Delete mediante ArticuloDao
    
    //Se utiliza ina anotacion autowired para el objeto ArticuloDao
    //Si ya se esta en memoria se use ese... Sino se crea (singleton)
    @Autowired
    private ArticuloDao articuloDao;
    
    
    //retorna la lista de articulos
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)articuloDao.findAll(); 
        
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    //Dado un articulo.id se busca en la tabla y 
    // se retorna todo el objeto Articulo
    @Override
    @Transactional(readOnly = true)    
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
    //Si articulo.id tiene un valor se busca y e actualiza
    // Si articulo.id No tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional    
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }
    
    //elimina el registro que tiene el id igual a articulo.id
    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);        
    }
}
