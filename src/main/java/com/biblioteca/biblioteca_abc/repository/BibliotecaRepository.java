package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Biblioteca;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository  {

    private final List<Biblioteca> bibliotecas = new ArrayList<>();
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public List<Biblioteca> findAll(){
        return bibliotecas;
    }

    public Biblioteca findById(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                return  biblioteca;
            }
        }
        return null;
    }

    public Biblioteca save(Biblioteca biblioteca){
        atomicInteger.incrementAndGet();
        biblioteca.setId((atomicInteger.get()));
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public Biblioteca delete(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                bibliotecas.remove(biblioteca);
                return biblioteca;
            }
        }
        return null;
    }

    public Biblioteca update(Integer id, Biblioteca novaBiblioteca) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                if(novaBiblioteca.getNome() != null && !novaBiblioteca.getNome().isBlank()) {
                    biblioteca.setNome(novaBiblioteca.getNome());
                }
                if(novaBiblioteca.getTelefone() != null && !novaBiblioteca.getTelefone().isBlank()) {
                    biblioteca.setTelefone(novaBiblioteca.getTelefone());
                }
                return biblioteca;
            }
        }
        return null;
    }

}
