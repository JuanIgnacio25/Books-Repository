/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.controllers;

import com.egg.Libreria.Services.AutorService;
import com.egg.Libreria.Services.EditorialService;
import com.egg.Libreria.Services.LibroService;
import com.egg.Libreria.entities.Libro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Extre
 */
@Controller
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/list")
    public String listLibro(Model model) {
        model.addAttribute("libros", libroService.listAll());
        return "libro-list";
    }

    @GetMapping("/form")
    public String crearLibro(Model model, @RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Libro> optional = libroService.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("libro", optional.get());
            } else {
                return "redirect:/libro/list";
            }
        } else {
            model.addAttribute("libro", new Libro());
        }
        return "libro-form";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/libro/list";
    }

    @GetMapping("/delete")
    public String eliminarLibro(@RequestParam(required = true) String id) {
        libroService.deleteById(id);
        return "redirect:/libro/list";
    }
}
