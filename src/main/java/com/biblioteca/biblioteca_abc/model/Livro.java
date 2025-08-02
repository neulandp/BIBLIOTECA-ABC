package com.biblioteca.biblioteca_abc.model;

import lombok.Data;

@Data
public class Livro {
    //Atributos
    private Integer id;
    private String issn;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numPag;
}
