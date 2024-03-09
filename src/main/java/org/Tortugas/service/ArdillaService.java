package org.Tortugas.service;

import org.Tortugas.exception.RecordNotFoundException;
import org.Tortugas.model.Ardilla;
import org.Tortugas.repository.ArdillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArdillaService {

    @Autowired
    ArdillaRepository repo;

    public List<Ardilla> getAllArdillas() {
        return repo.findAll();
    }

    public Ardilla getArdillaById(int id) {
        Optional<Ardilla> ardilla = repo.findById((int) id);
        if (ardilla.isPresent()) {
            return ardilla.get();
        } else {
            throw new RecordNotFoundException("No se encontró una ardilla con el id: " + id);
        }
    }

    public Ardilla createOrUpdateArdilla(Ardilla ardilla) {
        return repo.save(ardilla);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }
}

