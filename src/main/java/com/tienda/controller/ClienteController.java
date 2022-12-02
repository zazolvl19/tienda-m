/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
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
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();     
        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.credito.limite;
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }
    
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";    
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        
        return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";   
    }
    
}
