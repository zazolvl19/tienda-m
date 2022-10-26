/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

/**
 *
 * @author isaac
 */
public interface ClienteService {
    //se definen los 4 metodos de un CRUD
    //Create Read Update Delete
    
    
    //retorna la lista de clientes
    public List<Cliente> getClientes();
    
    //Dado un cliente.id se busca en la tabla y 
    // se retorna todo el objeto Cliente
    public Cliente getCliente(Cliente cliente);
    
    //Si cliente.id tiene un valor se busca y e actualiza
    // Su cliente.id No tiene valor, se inserta el objeto en la tabla
    public void save(Cliente cliente);
    
    //elimina el registro que tiene el id igual a cliente.id
    public void delete(Cliente cliente);
}
