package com.biblioteca.biblioteca_abc.service;


import com.biblioteca.biblioteca_abc.model.Biblioteca;
import com.biblioteca.biblioteca_abc.repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca findById(Integer id){
        return bibliotecaRepository.findById(id);
    }

    public Biblioteca save(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca update(Integer id,Biblioteca biblioteca){
        return bibliotecaRepository.update(id,biblioteca);
    }

    public Biblioteca delete(Integer id){
        return bibliotecaRepository.delete(id);
    }

}

