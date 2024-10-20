package com.curso.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
    private int idAutor;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String documentoPessoal;

    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor() { }

    public Autor(int idAutor, String nome, String documentoPessoal) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.documentoPessoal = documentoPessoal;
    }


    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAutor == autor.idAutor && Objects.equals(nome, autor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor, nome);
    }
}
