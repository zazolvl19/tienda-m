/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author isaac
 */
public interface ClienteDao extends JpaRepository<Cliente,Long> {
    
    
}
