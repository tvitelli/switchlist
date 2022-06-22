package org.timvitelli.switchlist.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.models.Track;
import org.timvitelli.switchlist.services.EquipmentService;
import org.timvitelli.switchlist.services.TrackService;

import java.util.List;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService;
    private TrackService trackService;
    private static final String EQUIPMENT = "/equipment";
    @Autowired
    public EquipmentController(EquipmentService equipmentService, TrackService trackService) {
        super();
        this.equipmentService = equipmentService;
        this.trackService = trackService;
    }

    //handler method to handle list of equipment and return model and view
    @GetMapping(EQUIPMENT)
    public String listEquipment(Model model) {
        model.addAttribute("equipment", equipmentService.getAllEquipment());
        return "equipment";
    }
    @GetMapping("/equipment/new")
    public String createEquipmentForm(Model model) {
        //create equipment object to hold equipment form data using Track table for choices
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        model.addAttribute("track", trackService.getAllTrack());
        return "create_equipment";
    }

    @PostMapping(EQUIPMENT)
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipment";
    }
    @GetMapping("/equipment/edit/{id}")
    public String editEquipmentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("equipment", equipmentService.getEquipmentById(id));
        model.addAttribute("track", trackService.getAllTrack());
        //allows edit of location and load status of equipment
        return "edit_equipment";
    }
    @PostMapping("/equipment/{id}")
    public String updateEquipment(@PathVariable Integer id, @ModelAttribute("equipment") Equipment equipment, Model model) {
        //get equipment from database by id
        Equipment existingEquipment = equipmentService.getEquipmentById(id);
        existingEquipment.setId(id);
        existingEquipment.setReportingMark(equipment.getReportingMark());
        existingEquipment.setCurrentLocation(trackService.getTrackById(Integer.parseInt(equipment.getCurrentLocation().getTrackName())));
        existingEquipment.setFutureLocation(trackService.getTrackById(Integer.parseInt(equipment.getFutureLocation().getTrackName())));
        existingEquipment.setLoadStatus(equipment.getLoadStatus());
        existingEquipment.setTypeId(equipment.getTypeId());
        existingEquipment.setLength(equipment.getLength());
        existingEquipment.setOwnerId(equipment.getOwnerId());
        //saves updated equipment
        equipmentService.updateEquipment(existingEquipment);
        return "redirect:/equipment";

    }
    @GetMapping("/equipment/{id}")
    public String deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipmentById(id);
        return "redirect:/equipment";
    }
}
