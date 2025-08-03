package com.biblioteca.biblioteca_abc.controller;

import com.biblioteca.biblioteca_abc.model.Autor;
import com.biblioteca.biblioteca_abc.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/autor")
public class AutorController {
    private final AutorRepository autorRepository;

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        try {
            var result = autorRepository.save(autor);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Autor>> listAll(){
        try {
            var result = autorRepository.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            autorRepository.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findByid(@PathVariable Integer id){
        Autor result = autorRepository.findById(id);
            if(result == null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autor){
        try {
            var result = autorRepository.update(id, autor);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
