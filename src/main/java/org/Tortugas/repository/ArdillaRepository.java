package org.Tortugas.repository;

import org.Tortugas.model.Ardilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArdillaRepository extends JpaRepository<Ardilla, Integer> {

}
