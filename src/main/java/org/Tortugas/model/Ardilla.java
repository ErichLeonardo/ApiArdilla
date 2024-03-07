package org.Tortugas.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ardilla")
public class Ardilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "puntos")
    private int puntos;

    @Column(name = "skin")
    private String skin;

    //una pardilla puede tener muchos poemas y un poema puede ser de muchas ardillas
    @ManyToMany
    @JoinTable(
            name = "ardilla_poema",
            joinColumns = @JoinColumn(name = "id_ardilla"),
            inverseJoinColumns = @JoinColumn(name = "id_poema")
    )
    private Set<Poema> poemas;

    public Ardilla() {
    }

    public Ardilla(int id, String nombre, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.skin = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
