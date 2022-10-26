/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author isaac
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    //se implementan los 4 metodos de un CRUD
    //Create Read Update Delete mediante ClienteDao
    
    //Se utiliza ina anotacion autowired para el objeto ClienteDao
    //Si ya se esta en memoria se use ese... Sino se crea (singleton)
    @Autowired
    private ClienteDao clienteDao;
    
    
    //retorna la lista de clientes
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();        
    }
    
    //Dado un cliente.id se busca en la tabla y 
    // se retorna todo el objeto Cliente
    @Override
    @Transactional(readOnly = true)    
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    //Si cliente.id tiene un valor se busca y e actualiza
    // Si cliente.id No tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional    
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
    //elimina el registro que tiene el id igual a cliente.id
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);        
    }
}
