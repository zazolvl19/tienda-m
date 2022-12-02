/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;


import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author isaac
 */
@Service("userDetailService")
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //se busca el usuario en la tabla usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario==null){ //usuario no existe en BD
            throw new UsernameNotFoundException(username);
        }
        //se cargan los roles del usuario en un arreglo especial de tipo GrantedAuthority
        var roles = new ArrayList<GrantedAuthority>();
        //se recorren el arraylist del objeto usuario y se transforma en GrantedAuthority cada rol
        for(Rol rol:usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        //retorna un userDetails con la info recuperada
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
            
        
        
    }
    
    
}

    
    
   
