package com.curso.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_editora")
    private int idEditora;

    @NotNull
    @NotBlank
    private String cnpj;

    @NotNull
    @NotBlank
    private String razaoSocial;

    @JsonIgnore
    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();
    
    public Editora() { }

    public Editora(int idEditora, String cnpj, String razaoSocial) {
        this.idEditora = idEditora;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setId(int id) {
        this.idEditora = idEditora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Livro> getLivros(){
        return livros;
    }

    public void setLivros(List<Livro> livros){
        this.livros = livros;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return idEditora == editora.idEditora && Objects.equals(cnpj, editora.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEditora, cnpj);
    }
}
