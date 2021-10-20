/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.Services;

import com.egg.Libreria.entities.Editorial;
import com.egg.Libreria.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Extre
 */
@Service
public class EditorialService {
    
    @Autowired
    private EditorialRepository autorRepository;

    public Editorial save(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        return autorRepository.save(editorial);
    }

    public Editorial save(Editorial editorial) {
        if (editorial.getNombre() == null) {
            
        }
        return autorRepository.save(editorial);
    }
}
