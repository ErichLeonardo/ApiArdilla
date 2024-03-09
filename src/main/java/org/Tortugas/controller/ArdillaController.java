package org.Tortugas.controller;

import org.Tortugas.model.Ardilla;
import org.Tortugas.service.ArdillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ardilla")
public class ArdillaController {

    @Autowired
    ArdillaService service;

    @GetMapping
    public List<Ardilla> getAllArdillas() {
        return service.getAllArdillas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ardilla> getArdillaById(@PathVariable("id") int id) {
        Ardilla ardilla = service.getArdillaById(id);
        return ResponseEntity.ok(ardilla);
    }

    @PostMapping
    public ResponseEntity<Ardilla> createOrUpdateArdilla(@RequestBody Ardilla ardilla) {
        Ardilla createdOrUpdatedArdilla = service.createOrUpdateArdilla(ardilla);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrUpdatedArdilla);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArdilla(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

