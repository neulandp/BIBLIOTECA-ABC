package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Editora;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {
    private AtomicInteger atomic = new AtomicInteger(0);
    private final List<Editora> editoras = new ArrayList<>();

    public Editora save(Editora editora){ //Não é necessário instanciar o objeto, pois ele já existe, aqui estou passando
        //o modelo do livro, por isso o objeto não é instanciado dentro do metodo
        atomic.incrementAndGet();
        editora.setId(atomic.get());
        editoras.add(editora);
        return editora;
    }

    public List<Editora> listAll(){
        return editoras;
    }

    public void delete(Integer id){
        for(Editora editora : editoras){
            if(editora.getId().equals(id)){
                editoras.remove(editora);
                return;
            }
        }
    }

    public Editora findById(Integer id){
        for(Editora editora : editoras){
            if(editora.getId().equals(id)){
                return editora;
            }
        }
        return null;
    }

    public Editora update(Integer id, Editora novaEditora) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                editora.setNome(novaEditora.getNome());
                editora.setEndereco(novaEditora.getEndereco());
                editora.setTelefone(novaEditora.getTelefone());
                return editora;
            }
        }
        return null;
    }
}
