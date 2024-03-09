package org.Tortugas.controller;

import org.Tortugas.model.Poema;
import org.Tortugas.service.PoemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/poema")
public class PoemaController {

    @Autowired
    PoemaService service;

    @GetMapping
    public List<Poema> getAllPoemas() {
        return service.getAllPoemas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poema> getPoemaById(@PathVariable int id) {
        Poema poema = service.getPoemaById(id);
        return ResponseEntity.ok(poema);
    }

    @PostMapping
    public ResponseEntity<Poema> createOrUpdatePoema(@RequestBody Poema poema) {
        Poema createdOrUpdatedPoema = service.createOrUpdatePoema(poema);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrUpdatedPoema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoema(@PathVariable int id) {
        service.deletePoema(id);
        return ResponseEntity.noContent().build();
    }
}
