package org.Tortugas.controller;

import org.Tortugas.model.Ardilla;
import org.Tortugas.service.ArdillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ardilla")
public class ArdillaController {

    @Autowired
    ArdillaService service;

    @RequestMapping("/all")
    public Iterable<Ardilla> findAll() {
        return service.findAll();
    }

    @RequestMapping("/find")
    public Ardilla findById(int id) {
        return service.findById(id);
    }

    @RequestMapping("/create")
    public void create(Ardilla ardilla) {
        service.save(ardilla);
    }

    @RequestMapping("/delete")
    public void deleteAll() {
        service.deleteAll();
    }

    @RequestMapping("/update")
    public void update(Ardilla ardilla) {
        service.update(ardilla);
    }

}
