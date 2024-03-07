package org.Tortugas.controller;

import org.Tortugas.model.Poema;
import org.Tortugas.service.PoemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/poema")
public class PoemaController {
    @Autowired
    PoemaService service;

    @RequestMapping("/all")
    public Iterable<Poema> findAll() {
        return service.findAll();
    }

    @RequestMapping("/find")
    public Poema findById(int id) {
        return service.findById(id);
    }

    @RequestMapping("/create")
    public void create(Poema poema) {
        service.save(poema);
    }

    @RequestMapping("/delete")
    public void deleteAll() {
        service.deleteAll();
    }

    @RequestMapping("/update")
    public void update(Poema poema) {
        service.update(poema);
    }

}
