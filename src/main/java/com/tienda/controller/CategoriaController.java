/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.controller.*;
import com.tienda.domain.Categoria;
import com.tienda.dao.CategoriaDao;
import com.tienda.service.CategoriaService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author isaac
 */
@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
           
        return "/categoria/listado";
    }
    
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "modificarCategoria";
    }
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/";    
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {
        
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";   
    }
    
}
