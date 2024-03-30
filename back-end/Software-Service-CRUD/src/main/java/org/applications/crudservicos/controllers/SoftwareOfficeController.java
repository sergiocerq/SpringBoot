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
    public ResponseEntity<SoftwareOfficeDTO> deleteSoftwareOffice(@PathVariable Integer id, UriComponentsBuilder uriComponentsBuilder) {
        return null;
    }

}
