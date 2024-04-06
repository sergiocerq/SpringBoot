package org.applications.crudservicos.repositories;

import org.applications.crudservicos.dtos.SoftwareOfficeDTO;
import org.applications.crudservicos.entities.SoftwareOffice;
import org.applications.crudservicos.entities.TypeOfSoftwareOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface SotwareOfficeRepository extends JpaRepository<SoftwareOffice, Integer> {

     SoftwareOfficeDTO findById(String id);

     List<SoftwareOffice> findByNameIgnoreCase(String name);

     List<SoftwareOffice> findByTypeContainingIgnoreCase(String name);

}
