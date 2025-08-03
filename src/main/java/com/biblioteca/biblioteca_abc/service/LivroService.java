package com.biblioteca.biblioteca_abc.service;

import com.biblioteca.biblioteca_abc.model.Livro;
import com.biblioteca.biblioteca_abc.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listAll(){
        return livroRepository.listAll();
    }

    public void delete(Integer id){
        livroRepository.delete(id);
    }

    public Livro findById(Integer id){
        return livroRepository.findById(id);
    }

    public Livro update(Integer id, Livro novoLivro){
        return livroRepository.update(id, novoLivro);
    }
}
