/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;


import com.tienda.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author isaac
 */
public interface UsuarioDao extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);   
    

}
