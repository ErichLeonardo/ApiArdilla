package org.Tortugas.service;

import org.Tortugas.model.Poema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PoemaService {
    @Autowired
    PoemaService service;

    public Iterable<Poema> findAll() {
        return service.findAll();
    }

    public Poema findById(int id) {
        return service.findById(id);
    }

    public void save(Poema poema) {
        service.save(poema);
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM Poema")
    public void deleteAll() {
        service.deleteAll();
    }

    public void update(Poema poema) {
        service.update(poema);
    }
}
