package org.coursera.jali.entities;

import javax.persistence.*;

@Entity
@Table(name = "LIVROS")
public class Livro {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIVRO_ID")
    @Id
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "NOMESAUTORES")
    private String nomesAutores;

    @Column(name = "NUMEROPAGINAS")
    private Integer numeroPaginas;

    @Column(name = "ESTILO")
    private String estilo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomesAutores() {
        return nomesAutores;
    }

    public void setNomesAutores(String nomesAutores) {
        this.nomesAutores = nomesAutores;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
