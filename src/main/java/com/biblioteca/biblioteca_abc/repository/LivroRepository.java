package com.biblioteca.biblioteca_abc.repository;

import com.biblioteca.biblioteca_abc.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository //Para entender que esse é nosso repositório que vai servir
//como se fosse um banco de dados
public class LivroRepository {
    private AtomicInteger atomic = new AtomicInteger(0); //Variável para gerar id´s de forma automática
    private final List<Livro> livros = new ArrayList<>(); //Cria uma lista de livros

    public Livro save(Livro livro){ //Recebe o "Livro", pois é um modelo já pronto
        atomic.incrementAndGet(); //Gera o id automaticamente e incrementa mais um
        livro.setId(atomic.get()); //Pego o valor do id e seta para o livro
        livros.add(livro); //Salva o novo livro na lista de livros
        return livro; //Retornar e mostrar o novo livro que eu setei
    }

    public List<Livro> listAll(){ //Metodo para mostrar a lista de todos os objetos
        return livros; //Retorna todos os livros
    }

    public Livro delete(Integer id){ //Metodo para deletar os objetos
        for(Livro livro : livros){ //Percorre todos os livros que existe dentro da lista
            if(livro.getId().equals(id)){ //Compara o id passado com o id que tem na lista
                livros.remove(livro); //Remove o livro com o id passado
                return livro; //Encerra o metodo
            }
        }
        return null;
    }

    public Livro findById(Integer id){ //Metodo para encontrar algum objeto com o id especificado
        for(Livro livro : livros){ //Percorre todos os livros existentes na lista
            if(livro.getId().equals(id)){ //Compara o id passado com o id que tem na lista
                return livro; //Retorna o livro com o id passado
            }
        }
        return null; //Se não encontrar, retorna nulo
    }

    public Livro update(Integer id, Livro novoLivro){ //Metodo para atualizar algum livro existente
        for(Livro livro : livros){ //Percorre a lista de livros adicionados
            if(novoLivro.getId().equals(id)){ //Compara o id passado com o id que tem na lista
                if(novoLivro.getIssn() != null && !novoLivro.getIssn().isBlank()){
                livro.setIssn(novoLivro.getIssn()); //Atualiza todos os atributos
                }
                if(novoLivro.getTitulo() != null && !novoLivro.getTitulo().isBlank()) {
                    livro.setTitulo(novoLivro.getTitulo());
                }
                if(novoLivro.getSinopse() != null && !novoLivro.getSinopse().isBlank()) {
                    livro.setSinopse(novoLivro.getSinopse());
                }
                if(novoLivro.getAno() != null) {
                    livro.setAno(novoLivro.getAno());
                }
                if(novoLivro.getNumPag() != null) {
                    livro.setNumPag(novoLivro.getNumPag());
                }
                return livro; //Retorna o livro atualizado
            }
        }
        return null; //Encerra
    }
}
