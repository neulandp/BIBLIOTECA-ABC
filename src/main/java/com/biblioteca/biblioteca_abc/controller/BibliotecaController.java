package com.biblioteca.biblioteca_abc.controller;

import com.biblioteca.biblioteca_abc.model.Biblioteca;
import com.biblioteca.biblioteca_abc.service.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController  // DEFINE A CLASSE COMO UM CONTROLADOR REST
@RequestMapping("/api/biblioteca")  // DEFINE ENDPOINT BASE DA API
@RequiredArgsConstructor  // GERA CONSTRUTOR AUTOMÁTICO PARA OS ATRIBUTOS FINAL (LOMBOK)
public class BibliotecaController {

        // FINAL GARANTE QUE A VARIÁVEL NÃO SERÁ REATRIBUÍDA
        private final BibliotecaService bibliotecaService;

        @GetMapping("/findAll")
        public ResponseEntity<List<Biblioteca>> findAll() {
            try{
                var result = bibliotecaService.findAll();
                return  new ResponseEntity<>(result, HttpStatus.OK);
            }catch (Exception ex){
                return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/findById/{id}")
        public ResponseEntity<Biblioteca> findByid(@PathVariable Integer id) {
            try {
                Biblioteca result = bibliotecaService.findById(id);
                if (result == null) {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(result, HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping("/save")
        public ResponseEntity<Biblioteca> save(@RequestBody Biblioteca biblioteca) {
            try {
                var result = bibliotecaService.save(biblioteca);
                return new ResponseEntity<>(result,HttpStatus.CREATED); //Se der certo e salvar
            } catch (Exception ex) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }
        }

        // PUT - ATUALIZAR
        @PutMapping("/update/{id}")
        public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca biblioteca){
            try{
                var result = bibliotecaService.update(id,biblioteca);

                if (result == null) {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(result,HttpStatus.OK);

            } catch (Exception ex) {
                return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Biblioteca> delete(@PathVariable Integer id) {
            try {
               var result =  bibliotecaService.delete(id);
                if (result == null) {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(null,HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }
        }

}
