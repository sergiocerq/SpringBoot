package org.applications.crudservicos.dtos;

import org.applications.crudservicos.entities.SoftwareOffice;
import org.applications.crudservicos.entities.TypeOfSoftwareOffice;

public record SoftwareOfficeDTO(String name, Integer qtd_persons_allocated, TypeOfSoftwareOffice type) {

    public SoftwareOfficeDTO(SoftwareOffice s) {
        this(s.getName(), s.getQtd_persons_allocated(), s.getType());
    }

}
