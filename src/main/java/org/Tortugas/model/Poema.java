package org.Tortugas.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "poema")
public class Poema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name="puntos_poema")
    private int puntos;

    @ManyToMany(mappedBy = "poemas")
    private Set<Ardilla> ardillas;

    public Poema() {
    }

    public Poema(int id, String titulo, String contenido, int puntos) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


}
