package org.Tortugas.repository;

import org.Tortugas.model.Poema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoemaRepository extends JpaRepository<Poema, Integer> {

    Iterable<Poema> findAllByOrderByIdDesc();



}
