package org.Tortugas.service;

import org.Tortugas.exception.RecordNotFoundException;
import org.Tortugas.model.Poema;
import org.Tortugas.repository.PoemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PoemaService {

    @Autowired
    PoemaRepository repo;

    public List<Poema> getAllPoemas() {
        return repo.findAll();
    }

    public Poema getPoemaById(int id) {
        Optional<Poema> poema = repo.findById(id);
        if (poema.isPresent()) {
            return poema.get();
        } else {
            throw new RecordNotFoundException("No se encontró un poema con el id: " + id);
        }
    }

    public Poema createOrUpdatePoema(Poema poema) {
        return repo.save(poema);
    }


    public void deletePoema(int id) {
        repo.deleteById(id);
    }
}
