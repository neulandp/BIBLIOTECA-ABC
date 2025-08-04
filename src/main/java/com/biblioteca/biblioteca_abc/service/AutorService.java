package com.biblioteca.biblioteca_abc.service;

import com.biblioteca.biblioteca_abc.model.Autor;
import com.biblioteca.biblioteca_abc.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }

    public List<Autor> listAll(){
        return autorRepository.listAll();
    }

        public Autor delete(Integer id){
        return autorRepository.delete(id);
    }

    public Autor findById(Integer id){
        return autorRepository.findById(id);
    }

    public Autor update(Integer id, Autor novoautor){
        return autorRepository.update(id, novoautor);
    }
}
