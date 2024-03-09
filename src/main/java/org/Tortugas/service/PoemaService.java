package org.Tortugas.service;

import org.Tortugas.model.Poema;
import org.Tortugas.repository.PoemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PoemaService {

    private final PoemaRepository poemaRepository; // Inyecta el repositorio en lugar de PoemaService

    @Autowired
    public PoemaService(PoemaRepository poemaRepository) {
        this.poemaRepository = poemaRepository;
    }

    public Iterable<Poema> findAll() {
        return poemaRepository.findAll();
    }

    public Poema findById(int id) {
        return poemaRepository.findById(id).orElse(null);
    }

    public void save(Poema poema) {
        poemaRepository.save(poema);
    }

    @Transactional
    public void deleteAll() {
        poemaRepository.deleteAll();
    }

    public void update(Poema poema) {
        poemaRepository.save(poema);
    }
}
