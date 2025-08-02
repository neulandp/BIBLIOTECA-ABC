package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Autor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {
    private AtomicInteger atomic = new AtomicInteger(3);
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

    public void delete(Integer id){
        for(Autor autor : autores){
            if(autor.getId().equals(id)){
                autores.remove(autor);
                return;
            }
        }
    }

    public Autor findById(Integer id){
        for(Autor autor : autores){
            if(autor.getId().equals(id)){
                return autor;
            }
        }
        return null;
    }
}
