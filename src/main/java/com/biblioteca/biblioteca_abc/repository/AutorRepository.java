package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Autor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {
    private AtomicInteger atomic = new AtomicInteger(0);
    private final List<Autor> autores = new ArrayList<>();

    public Autor save(Autor autor){
        atomic.incrementAndGet();
        autor.setId(atomic.get());
        autores.add(autor);
        return autor;
    }

    public List<Autor> listAll(){
        return autores;
    }

    public Autor delete(Integer id){
        for(Autor autor : autores){
            if(autor.getId().equals(id)){
                autores.remove(autor);
                return autor;
            }
        }
        return null;
    }

    public Autor findById(Integer id){
        for(Autor autor : autores){
            if(autor.getId().equals(id)){
                return autor;
            }
        }
        return null;
    }

    public Autor update(Integer id, Autor novoAutor){
        for(Autor autor : autores){
            if(autor.getId().equals(id)){
                if(novoAutor.getNome() != null && !novoAutor.getNome().isBlank()) {
                    autor.setNome(novoAutor.getNome());
                }
                if(novoAutor.getCpf() != null && !novoAutor.getCpf().isBlank()) {
                    autor.setCpf(novoAutor.getCpf());
                }
                if(novoAutor.getIdade() != null) {
                    autor.setIdade(novoAutor.getIdade());
                }
                return autor;
            }
        }
        return null;
    }
}
