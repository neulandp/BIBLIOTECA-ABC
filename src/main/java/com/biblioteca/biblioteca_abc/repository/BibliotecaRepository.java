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
    private AtomicInteger atomicInteger = new AtomicInteger(1);

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

    @PostConstruct //Executa esse metodo de forma automática e adiciona o objeto abaixo
    public void init(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(1);
        biblioteca.setNome("Debora");
        biblioteca.setTelefone("(45) 99994-7703");
    }

    public Biblioteca save(Biblioteca biblioteca){
        atomicInteger.incrementAndGet();
        biblioteca.setId((atomicInteger.get()));
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public void delete(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                bibliotecas.remove(biblioteca);
                return;
            }
        }
    }

    public Biblioteca update(Integer id, Biblioteca novaBiblioteca) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                biblioteca.setNome(novaBiblioteca.getNome());
                biblioteca.setTelefone(novaBiblioteca.getTelefone());
                return biblioteca;
            }
        }
        return null;
    }

}
