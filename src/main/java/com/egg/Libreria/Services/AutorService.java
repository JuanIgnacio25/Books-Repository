/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.Services;

import com.egg.Libreria.entities.Autor;
import com.egg.Libreria.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Extre
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor save(String nombre) {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        return autorRepository.save(autor);
    }

    public Autor save(Autor autor) {
        if (autor.getNombre() == null) {
            
        }
        return autorRepository.save(autor);
    }
}
