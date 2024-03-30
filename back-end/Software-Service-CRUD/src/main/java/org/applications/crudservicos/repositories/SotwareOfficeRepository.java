package org.applications.crudservicos.repositories;

import org.applications.crudservicos.dtos.SoftwareOfficeDTO;
import org.applications.crudservicos.entities.SoftwareOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SotwareOfficeRepository extends JpaRepository<SoftwareOffice, Integer> {

    public SoftwareOfficeDTO findById(String id);
}
