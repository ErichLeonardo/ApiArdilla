package org.Tortugas.service;

import org.Tortugas.model.Ardilla;
import org.Tortugas.repository.ArdillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArdillaService {
    @Autowired
    ArdillaRepository repo;


    public Iterable<Ardilla> findAll() {
        return repo.findAllByOrderByIdDesc();
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM Ardilla")
    public void deleteAll() {
        repo.deleteAll();
    }


    public void update(Ardilla ardilla) {
        repo.save(ardilla);
    }

    public void save(Ardilla ardilla) {
        repo.save(ardilla);
    }


    public Ardilla findById(int id) {
        return repo.findById(id).get();
    }
}
