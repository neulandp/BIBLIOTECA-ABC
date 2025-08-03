package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Biblioteca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository {
    private AtomicInteger atomic = new AtomicInteger(3);
    private final List<Biblioteca> bibliotecas = new ArrayList<>();

    public Biblioteca save(Biblioteca biblioteca){
        atomic.incrementAndGet();
        biblioteca.setId(atomic.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public List<Biblioteca> listAll(){
        return bibliotecas;
    }

    public void delete(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                bibliotecas.remove(biblioteca);
                return;
            }
        }
    }
}
