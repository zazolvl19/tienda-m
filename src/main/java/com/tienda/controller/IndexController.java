/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.service.ArticuloService;
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
    private ArticuloService clienteService;
    
    
    @GetMapping("/")
    public String inicio(Model model) {
         
       var articulos = clienteService.getArticulos(true);
        model.addAttribute("articulo",articulos);
        return "index";
    }
}
