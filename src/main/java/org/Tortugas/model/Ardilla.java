package org.Tortugas.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ardilla")
public class Ardilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "puntos")
    private int puntos;


    @ManyToMany
    @JoinTable(
            name = "ardilla_poema",
            joinColumns = @JoinColumn(name = "ardilla_id"),
            inverseJoinColumns = @JoinColumn(name = "poema_id")
    )
    private Set<Poema> poemas;


    public Ardilla() {
    }

    public Ardilla(int id, String dni, String email, String password, String nombre, int puntos) {
        this.id = id;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


}
