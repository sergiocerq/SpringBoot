package org.applications.crudservicos.services;

import org.applications.crudservicos.dtos.SoftwareOfficeDTO;
import org.applications.crudservicos.entities.SoftwareOffice;
import org.applications.crudservicos.repositories.SotwareOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class SoftwareOfficeService {

    @Autowired
    private SotwareOfficeRepository sotwareOfficeRepository;

    public List<SoftwareOfficeDTO> listSoftwareOffice() {
        return sotwareOfficeRepository.findAll()
                                      .stream()
                                      .map(SoftwareOfficeDTO::new)
                                      .toList();
    }

    public List<SoftwareOfficeDTO> listSoftwareOfficeContainingName(String name) {
        return sotwareOfficeRepository.findByNameIgnoreCase(name)
                                      .stream()
                                      .map(SoftwareOfficeDTO::new)
                                      .toList();
    }

    public List<SoftwareOfficeDTO> listSoftwareOfficeByType(String type) {
        return sotwareOfficeRepository.findByTypeContainingIgnoreCase(type)
                                      .stream()
                                      .map(SoftwareOfficeDTO::new)
                                      .toList();
    }

    public ResponseEntity<SoftwareOfficeDTO> createSoftwareOffice(
        SoftwareOfficeDTO newSoftwareOfficeDTO,
        UriComponentsBuilder uriComponentsBuilder
    ) {
        SoftwareOffice softwareOffice = new SoftwareOffice(newSoftwareOfficeDTO);
        sotwareOfficeRepository.save(softwareOffice);
        return ResponseEntity.created(uriComponentsBuilder.path("/${id}")
                             .buildAndExpand(softwareOffice.getId()).toUri())
                             .body(new SoftwareOfficeDTO(softwareOffice));
    }

    public ResponseEntity<SoftwareOfficeDTO> updateSoftwareOffice(
        Integer id,
        SoftwareOfficeDTO softwareOfficeDTO
    ) {
        Optional <SoftwareOffice> op = sotwareOfficeRepository.findById(id);
        if(!op.isEmpty()) {
            SoftwareOffice softwareOffice = op.get();
            softwareOffice.setName(softwareOfficeDTO.name());
            softwareOffice.setType(softwareOfficeDTO.type());
            sotwareOfficeRepository.save(softwareOffice);
            return ResponseEntity.ok(new SoftwareOfficeDTO(softwareOffice));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<SoftwareOfficeDTO> deleteSoftwareOffice(
        Integer id
    ) {
        Optional <SoftwareOffice> op = sotwareOfficeRepository.findById(id);
        if(!op.isEmpty()) {
            SoftwareOffice softwareOffice = op.get();
            sotwareOfficeRepository.delete(softwareOffice);
            return ResponseEntity.ok(new SoftwareOfficeDTO(op.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
