package com.biblioteca.biblioteca_abc.service;

import com.biblioteca.biblioteca_abc.model.Livro;
import com.biblioteca.biblioteca_abc.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //Cria construtor com os argumentos obrigatórios
@Service //Anota como um serviço
public class LivroService { //Classe de serviço, onde tem a regra de negócio
    private final LivroRepository livroRepository; //Não muda de referência após ser inicializada

    public Livro save(Livro livro){ //Salvar livros
        return livroRepository.save(livro);
    }

    public List<Livro> listAll(){ //Listar livros
        return livroRepository.listAll();
    }

    public Livro delete(Integer id){ //Deletar livros
        return livroRepository.delete(id);
    }

    public Livro findById(Integer id){ //Encontrar livros pelo id
        return livroRepository.findById(id);
    }

    public Livro update(Integer id, Livro novoLivro){ //Atualizar livros
        return livroRepository.update(id, novoLivro);
    }
}
