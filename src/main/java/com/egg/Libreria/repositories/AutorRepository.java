/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.Libreria.repositories;

import com.egg.Libreria.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Extre
 */
public interface AutorRepository extends JpaRepository<Autor, String>{
    
}
