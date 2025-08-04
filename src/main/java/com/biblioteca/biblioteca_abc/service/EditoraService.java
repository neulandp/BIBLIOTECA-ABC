package com.biblioteca.biblioteca_abc.service;

import com.biblioteca.biblioteca_abc.model.Editora;
import com.biblioteca.biblioteca_abc.model.Livro;
import com.biblioteca.biblioteca_abc.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EditoraService {
    private final EditoraRepository editoraRepository;

    public Editora save(Editora editora){
        return editoraRepository.save(editora);
    }

    public List<Editora> listAll(){
        return editoraRepository.listAll();
    }

    public Editora delete(Integer id){
        return editoraRepository.delete(id);
    }

    public Editora findById(Integer id){
        return editoraRepository.findById(id);
    }

    public Editora update(Integer id, Editora novaEditora){
        return editoraRepository.update(id, novaEditora);
    }
}
