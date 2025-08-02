package com.biblioteca.biblioteca_abc.controller;

import com.biblioteca.biblioteca_abc.model.Livro;
import com.biblioteca.biblioteca_abc.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/livro")
public class LivroController {
    private final LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<Livro>save(@RequestBody Livro livro){
        try {
            var result = livroService.save(livro);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Livro>>listAll(){
        try {
            var result = livroService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        try {
            livroService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
