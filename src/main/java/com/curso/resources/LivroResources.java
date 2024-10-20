package com.curso.resources;


import com.curso.domains.Livro;
import com.curso.domains.dtos.LivroDTO;
import com.curso.services.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/livro")
public class LivroResources {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable long id){
        Livro obj = this.livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping(value="/isbn/{isbn}")
    public ResponseEntity<LivroDTO> findByIsbn(@PathVariable String isbn){
        Livro obj = this.livroService.findByIsbn(isbn);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }
}
