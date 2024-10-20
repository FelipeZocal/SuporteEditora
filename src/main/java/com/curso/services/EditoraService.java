package com.curso.services;

import com.curso.domains.Editora;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.repositories.EditoraRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepo;

    public List<EditoraDTO> findAll(){
        //retorna lista de EditoraDTO
        return editoraRepo.findAll().stream()
                .map(obj -> new EditoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Editora findbyId(Integer id){
        Optional<Editora> obj = editoraRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Editora não encontrada! Id: "+id));
    }

    public Editora findByCnpj(String cnpj){
        Optional<Editora> obj = editoraRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Editora não encontrada! Cnpj: "+cnpj));
    }
}
