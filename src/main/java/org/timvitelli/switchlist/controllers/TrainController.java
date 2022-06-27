package org.timvitelli.switchlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timvitelli.switchlist.models.Train;
import org.timvitelli.switchlist.repositories.TrainRepository;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    //Currently unused methods - needed for future enhancements
    @Autowired
    private TrainRepository trainRepository;

    @GetMapping
    public List<Train> train() {
        return trainRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Train get(@PathVariable Integer id) {
        return trainRepository.getOne(id);
    }

    @PostMapping
    public Train create(@RequestBody final Train train) {
        return trainRepository.saveAndFlush(train);
    }
}
