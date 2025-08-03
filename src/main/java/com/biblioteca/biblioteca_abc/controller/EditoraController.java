package com.biblioteca.biblioteca_abc.controller;

import com.biblioteca.biblioteca_abc.model.Editora;
import com.biblioteca.biblioteca_abc.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/editora")
public class EditoraController {

    private final EditoraService editoraService;

    @PostMapping("/save")
    public ResponseEntity<Editora> save(@RequestBody Editora editora){
        try {
            var result = editoraService.save(editora);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Editora>> listAll(){
        try {
            var result = editoraService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            editoraService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer id){
        try {
            var result = editoraService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editora> update(@PathVariable Integer id, @RequestBody Editora editora){
        try {
            var result = editoraService.update(id,editora);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
