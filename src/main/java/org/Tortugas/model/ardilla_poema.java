package org.Tortugas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ardilla_poema")
public class ardilla_poema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Ardilla ardilla;
    @ManyToOne
    private Poema poema;

    public ardilla_poema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ardilla getArdilla() {
        return ardilla;
    }

    public void setArdilla(Ardilla ardilla) {
        this.ardilla = ardilla;
    }

    public Poema getPoema() {
        return poema;
    }

    public void setPoema(Poema poema) {
        this.poema = poema;
    }

    @Override
    public String toString() {
        return "ardilla_poema{" +
                "id=" + id +
                ", ardilla=" + ardilla +
                ", poema=" + poema +
                '}';
    }
}
