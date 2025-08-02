package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository //Para entender que esse é nosso repositório que vai servir
//como se fosse um banco de dados
public class LivroRepository {
    //Livro livro = new Livro();
    private AtomicInteger atomic = new AtomicInteger(2);
    private final List<Livro> livros = new ArrayList<>();

    public Livro save(Livro livro){
        atomic.incrementAndGet(); //Gera o id automaticamente e incrementa mais um
        livro.setId(atomic.get()); //Pego o valor do id e seta para o livro
        livros.add(livro); //Salva o novo livro na lista de livros
        return livro; //Retornar e mostrar o novo livro que eu setei
    }

    public List<Livro> listAll(){
        return livros;
    }

    public void delete(Integer id){
        for(Livro livro : livros){
            if(livro.getId().equals(id)){
                livros.remove(livro);
                return;
            }
        }
    }
}
