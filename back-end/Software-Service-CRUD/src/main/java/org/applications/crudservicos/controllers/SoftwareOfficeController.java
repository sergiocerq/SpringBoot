package org.applications.crudservicos.controllers;


import jakarta.transaction.Transactional;
import org.applications.crudservicos.dtos.SoftwareOfficeDTO;
import org.applications.crudservicos.services.SoftwareOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/services")
public class SoftwareOfficeController {

    @Autowired
    private SoftwareOfficeService softwareOfficeService;

    @GetMapping
    public List<SoftwareOfficeDTO> listSoftwareOffice() {
        return softwareOfficeService.listSoftwareOffice();
    }

    @GetMapping("/${name}")
    public List<SoftwareOfficeDTO> listSoftwareOfficesContainingName(@PathVariable String name) {
        return softwareOfficeService.listSoftwareOfficeContainingName(name);
    }

    @GetMapping("/frontend")
    public List<SoftwareOfficeDTO> listSoftwareOfficeFrontend() {
        return softwareOfficeService.listSoftwareOfficeByType("FRONT-END");
    }

    @GetMapping("/backend")
    public List<SoftwareOfficeDTO> listSoftwareOfficeBackend() {
        return softwareOfficeService.listSoftwareOfficeByType("BACK-END");
    }

    @GetMapping("/devops")
    public List<SoftwareOfficeDTO> listSoftwareOfficeDevops() {
        return softwareOfficeService.listSoftwareOfficeByType("DEVOPS");
    }

    @PostMapping
    public ResponseEntity<SoftwareOfficeDTO> createSoftwareOffice(@RequestBody SoftwareOfficeDTO softwareOfficeDTO, UriComponentsBuilder uriComponentsBuilder) {
        return softwareOfficeService.createSoftwareOffice(softwareOfficeDTO, uriComponentsBuilder);
    }

    @PutMapping("/${id}")
    @Transactional
    public ResponseEntity<SoftwareOfficeDTO> updateSoftwreOffice(@PathVariable Integer id, @RequestBody SoftwareOfficeDTO softwareOfficeDTO) {
        return softwareOfficeService.updateSoftwareOffice(id, softwareOfficeDTO);
    }

    @DeleteMapping("/${id}")
    @Transactional
    public ResponseEntity<SoftwareOfficeDTO> deleteSoftwareOffice(@PathVariable Integer id) {
        return softwareOfficeService.deleteSoftwareOffice(id);
    }

}
