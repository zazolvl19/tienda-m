/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.controller.*;
import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author isaac
 */
@Controller
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    @GetMapping("/")
    public String inicio(Model model) {
        var texto="estamos en semana 4";
        model.addAttribute("mensaje",texto);
        
       /* Cliente cliente1 = new Cliente("Juan","Perez Moreno","jperez@gmail.com","8888-3555");
        Cliente cliente2 = new Cliente("Pedro","Moreno Perez","Pedro@gmail.com","8888-5565");
        Cliente cliente3 = new Cliente("Rebeca","Lopez Marquez","Rebeca@gmail.com","8888-4555");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3); */
       
       var clientes = clienteService.getClientes();
        
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
}
