/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.Services;

import com.egg.Libreria.entities.Libro;
import com.egg.Libreria.repositories.LibroRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    public List<Libro> listAll() {
        return libroRepository.findAll();
    }

    @Transactional
    public Libro save(Libro libro) {
        libro.setAutor(autorService.save(libro.getAutor().getNombre()));
        libro.setEditorial(editorialService.save(libro.getEditorial().getNombre()));
        return libroRepository.save(libro);
    }

    public Optional<Libro> findById(String id) {
        return libroRepository.findById(id);
    }

    @Transactional
    public void delete(Libro libro) {
        libroRepository.delete(libro);
    }

    @Transactional
    public void deleteById(String id) {
        Optional<Libro> optional = libroRepository.findById(id);
        if (optional.isPresent()) {
            libroRepository.delete(optional.get());
        }
    }
}
