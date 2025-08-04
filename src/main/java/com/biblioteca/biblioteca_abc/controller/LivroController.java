package com.biblioteca.biblioteca_abc.controller;

import com.biblioteca.biblioteca_abc.model.Livro;
import com.biblioteca.biblioteca_abc.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Responde a requisições HTTP
@RequiredArgsConstructor //Cria construtor automático
@RequestMapping("/api/livro") //Define o prefixo da rota
public class LivroController {
    private final LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<Livro>save(@RequestBody Livro livro){ //Pega o JSON enviado no corpo da requisição e converte num objeto Livro
        try {
            var result = livroService.save(livro); //Chama o service para salvar
            return new ResponseEntity<>(result,HttpStatus.CREATED); //Se der certo e salvar
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); //Se tiver erro
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Livro>>listAll(){
        try {
            var result = livroService.listAll(); //Retorna todos os livros
            return new ResponseEntity<>(result, HttpStatus.OK); //Se der certo, mostra a lista de livros
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); //Se der erro
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Livro>delete(@PathVariable Integer id){ //PathVariable pega o id passado na URL
        try {
            var result = livroService.delete(id);
            if (result == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null,HttpStatus.OK); //Se der certo e deletar
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); //Se der erro
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) { //Pega o id passado na URL

        try {
            var result = livroService.findById(id);
            if (result == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);//Se não existir
            }
            return new ResponseEntity<>(result, HttpStatus.OK);//Retorna o livro se achar
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro){ //Pega o id passado na URL e o novo conteúdo para o livro
        try {
            var result = livroService.update(id, livro);
            if (result == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);//Se não existir
            }
            return new ResponseEntity<>(result, HttpStatus.OK);// //Retorna com o livro atualizado
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); //Se der erro
        }
    }
}
