/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.Services;

import com.egg.Libreria.entities.Libro;
import com.egg.Libreria.repositories.LibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Extre
 */
@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    
    public List<Libro> listAll(){
    return libroRepository.findAll();
            }
}
