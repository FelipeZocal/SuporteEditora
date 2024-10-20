package com.curso.services;


import com.curso.domains.Livro;
import com.curso.domains.dtos.LivroDTO;
import com.curso.repositories.LivroRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepo;

    public List<LivroDTO> findAll() {
    return livroRepo.findAll().stream()
                .map(obj -> new LivroDTO(obj))
                .collect(Collectors.toList());
    }

    public Livro findById(Long id){
        Optional<Livro> obj = livroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: "+id));
    }

    public Livro findByIsbn(String isbn){
        Optional<Livro> obj = livroRepo.findByIsbn(isbn);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Isbn: "+isbn));
    }
}
