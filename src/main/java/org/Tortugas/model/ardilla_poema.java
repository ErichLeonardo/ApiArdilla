package org.Tortugas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ardilla_poema")
public class ardilla_poema {

    @Id
    private int id;
    @ManyToOne
    private Ardilla ardilla;
    @ManyToOne
    private Poema poema;

    public ardilla_poema() {
    }




}
